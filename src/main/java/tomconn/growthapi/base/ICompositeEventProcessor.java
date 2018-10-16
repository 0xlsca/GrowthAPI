package tomconn.growthapi.base;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.function.Consumer;

public interface ICompositeEventProcessor<E extends Event, P extends IEventPackage<E>> {

    /**
     * Called by {@link IEventHandler } before the decision-process starts
     *
     * @param parcel the event parcel
     * @return the respective {@link EventFutureAssessment}
     */
    EventFutureAssessment giveAssessmentOnEvent(P parcel);

    /**
     * Event-wrapper for {@link #giveAssessmentOnEvent(IEventPackage)}
     *
     * @param event the event
     * @return the respective result
     * @see #giveAssessmentOnEvent(IEventPackage)
     */
    default EventFutureAssessment giveAssessmentOnEvent(E event) {
        return giveAssessmentOnEvent(getPackageFactory().manufacture(event));
    }


    /**
     * Called by {@link IEventHandler} after it has made its decision
     *
     * @param assessment the resulting assessment by the {@link IEventHandler}
     */
    default void consumeResultingAssessment(EventFutureAssessment assessment) {
        Consumer<EventFutureAssessment> resultingAssessmentConsumer = this.getResultingAssessmentConsumer();
        if (resultingAssessmentConsumer != null) {
            resultingAssessmentConsumer.accept(assessment);
        }
    }

    Consumer<EventFutureAssessment> getResultingAssessmentConsumer();

    boolean setResultingAssessmentConsumer(Consumer<EventFutureAssessment> consumer);

    /**
     * Used on assessing whether this processor can handle the specified event
     *
     * @param eventclass the class of the {@link Event}
     * @return true if and only if this processor can process events of this kind, false otherwise
     */
    boolean canProcess(Class<E> eventclass);

    /**
     * Returns true if this processor is eligible for processing the passed event, meaning that it
     * wants to be included in the decision-making process
     *
     * @param event the respective event-instance
     * @return <ul>
     * <li>
     * {@code true} if and only if this processor is eligible for processing
     * the respective event-instance
     * </li>
     * <li>
     * {@code false} otherwise
     * </li>
     * </ul>
     */
    default boolean isEligible(E event) {
        return this.isEligible(this.getPackageFactory().manufacture(event));
    }

    /**
     * Returns true if this processor is eligible for processing the passed parcel, meaning that it
     * wants to be included in the decision-making process
     *
     * @param parcel the respective parcel-instance
     * @return <ul>
     * <li>
     * {@code true} if and only if this processor is eligible for processing
     * the respective parcel-instance
     * </li>
     * <li>
     * {@code false} otherwise
     * </li>
     * </ul>
     */
    boolean isEligible(P parcel);


    /**
     * Returns the currently used package-factory
     *
     * @return the currently used {@link IEventPackageFactory}
     */
    IEventPackageFactory<E, P> getPackageFactory();
}
