package tomconn.growthapi.base.processor;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.handler.IEventHandler;
import tomconn.growthapi.base.parcel.IEventParcel;
import tomconn.growthapi.base.parcel.IEventParcelFactory;

import java.util.function.Consumer;

public interface ICompositeEventProcessor<E extends Event, P extends IEventParcel<E>> {

    /**
     * Called by {@link IEventHandler } before the decision-process starts
     *
     * @param parcel the event parcel
     * @return the respective {@link EventFutureAssessment}
     */
    EventFutureAssessment giveAssessmentOnEvent(P parcel);

    /**
     * Event-wrapper for {@link #giveAssessmentOnEvent(IEventParcel)}
     *
     * @param event the event
     * @return the respective result
     * @see #giveAssessmentOnEvent(IEventParcel)
     */
    default EventFutureAssessment giveAssessmentOnEvent(E event) {
        return giveAssessmentOnEvent(getPackageFactory().manufacture(event));
    }


    /**
     * Called by {@link IEventHandler} after it has made its decision
     *
     * @param assessment the resulting assessment by the {@link IEventHandler}
     * @return
     * <ul>
     *      <li>
     *          true
     *          <ul>
     *              <li>
     *                  if the resulting {@link EventFutureAssessment} was successfully consumed
     *              </li>
     *          </ul>
     *      </li>
     *      <li>
     *          false
     *          <ul>
     *              <li>
     *                  if <code>assessment</code> was null
     *              </li>
     *              <li>
     *                  in all other cases
     *              </li>
     *          </ul>
     *      </li>
     * </ul>
     */
    default boolean consumeResultingAssessment(EventFutureAssessment assessment) {

        Consumer<EventFutureAssessment> resultingAssessmentConsumer = this.getResultingAssessmentConsumer();
        if (resultingAssessmentConsumer != null && assessment != null) {
            resultingAssessmentConsumer.accept(assessment);
            return true;
        }
        return false;
    }

    /**
     * Returns a consumer which will consume the resulting {@link EventFutureAssessment} of a  decision
     *
     * @return a consumer which accepts {@link EventFutureAssessment}
     * @implNote Returns a consumer which does nothing with the value provided
     * @implSpec This method should always return a non-null value
     */
    default Consumer<EventFutureAssessment> getResultingAssessmentConsumer() {
        return (ignored) -> {
        };
    }

    boolean setResultingAssessmentConsumer(Consumer<EventFutureAssessment> consumer);

    /**
     * Used on assessing whether this processor can handle the specified event
     *
     * @param eventclass the class of the {@link Event}
     * @return true if and only if this processor can process events of this kind, false otherwise
     */
    boolean canProcess(Class<? extends Event> eventclass);

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
    @SuppressWarnings("unchecked")
    default <V extends Event> boolean isEligible(V event) {
        return event != null && this.canProcess(event.getClass()) && this.isEligible(this.getPackageFactory().manufacture((E) event));
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
     * Returns a boolean depending on whether or not this processor is eligible for instances of the
     * provided parcel class
     *
     * @param parcelClass the class of the parcel
     * @return <ul>
     * <li>true
     * <ul>
     * <li> if and only if this processor is eligible for accepting instances of the passed class</li>
     * </ul></li>
     * <li>false
     * <ul>
     * <li>in all other cases</li>
     * </ul>
     * </li>
     * </ul>
     */
    boolean isEligible(Class<? extends IEventParcel<E>> parcelClass);


    /**
     * Returns the currently used package-factory
     *
     * @return the currently used {@link IEventParcelFactory}
     */
    IEventParcelFactory<E, P> getPackageFactory();
}
