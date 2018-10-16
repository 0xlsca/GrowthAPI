package tomconn.growthapi.base;

import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <E> the event handled by this handler
 * @param <X> the processor used in this handler
 */
public interface IEventHandler<E extends Event, X extends ICompositeEventProcessor<E, ? extends IEventPackage<E>>> {


    /**
     * Checks whether this handler can handle the specified event
     *
     * @param eventclass the class of the event
     * @return true if and only if this handler can handle events of the passed event class
     */
    boolean canHandle(@Nonnull Class<E> eventclass);


    /**
     * Orders this eventhandler to process the given event
     *
     * @param event the event
     */
    default boolean handleEvent(@Nonnull E event) {
        List<X> eligibles = this.getEligibleProcessors(event);
        IEventFutureDecisionMaker eventFutureDecisionMaker = this.getEventFutureDecisionMaker();
        if (eligibles != null && eventFutureDecisionMaker != null) {
            EventFutureAssessment assessment = eventFutureDecisionMaker.decide(
                    eligibles
                            .stream()
                            .map(
                                    proc -> proc.giveAssessmentOnEvent(event)
                            )
                            .collect(Collectors.toList())
            );

            event.setResult(assessment.getResult());
            eligibles.forEach(
                    c -> c.consumeResultingAssessment(assessment)
            );
            return true;
        }
        return false;
    }


    /**
     * Registers a processor for the given event with the respective package
     *
     * @param processor the processor
     * @return true if the processor was successfully registered, false if not
     */
    boolean registerProcessor(@Nonnull X processor);


    /**
     * Removes an already registered processor if and only if the passed processor is reference-identical with any registered processor
     *
     * @param processor the processor to remove
     * @return true if and only if a processor was found with the same
     */
    boolean removeProcessor(@Nonnull X processor);


    /**
     * Checks whether the provided processor is already registered in this {@link IEventHandler}
     *
     * @param processor the processor
     * @return true if and only if the provided instance is registered in this handler , false otherwise
     */
    boolean hasProcessor(@Nonnull X processor);

    /**
     * Returns a list with all currently registered processors
     *
     * @return a list with all registered processors
     */
    List<X> getProcessors();

    /**
     * Returns a list of all processors which can handle the provided event
     *
     * @param event the event-instance
     * @return a {@link List} containing all eligible {@link ICompositeBlockBasedEventProcessor}s
     */
    default List<X> getEligibleProcessors(E event) {
        List<X> processors = getProcessors();
        if (processors != null) {
            return processors.stream()
                    .filter(p -> p != null && p.isEligible(event))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * Sets the {@link IEventFutureDecisionMaker}
     *
     * @param decisionMaker the decision maker
     * @return true if and only if the decision maker has been set or was successfully swapped to the provided one,
     * false otherwise
     */
    boolean setEventFutureDecisionMaker(@Nonnull IEventFutureDecisionMaker decisionMaker);

    /**
     * Returns the currently set {@link IEventFutureDecisionMaker} in case there is one
     *
     * @return a {@link IEventFutureDecisionMaker} or null, depending on whether there is one set in this instance
     */
    IEventFutureDecisionMaker getEventFutureDecisionMaker();
}
