package tomconn.growthapi.base.processor;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.handler.IEventHandler;
import tomconn.growthapi.base.manager.IEventManager;
import tomconn.growthapi.base.parcel.IEventParcel;

import java.util.List;

/**
 * This interface shall help with easing the access to processors from the
 * {@link tomconn.growthapi.base.manager.IEventManager} level
 */
public interface EasyProcessorAPIForManager extends IEventManager {

    /**
     * Retrieves all processors which are handling the specified event and make use of the specified parcel
     *
     * @param eventClass  the class of the event
     * @param parcelClass the class of the parcel
     * @param <P>         Parcel parameter type
     * @param <E>         Event parameter type
     * @return a list with all currently in the {@link tomconn.growthapi.base.handler.IEventHandler}s of this
     * {@link tomconn.growthapi.base.manager.IEventManager} registered processors which match the provided classes
     */
    <P extends IEventParcel<E>, E extends Event> List<ICompositeEventProcessor<E, P>>
    retrieveProcessorsMatching(Class<E> eventClass, Class<P> parcelClass);

    /**
     * Retrieves all processors which make use of the specified parcel
     *
     * @param <P>         Parcel parameter type
     * @param <E>         Event parameter type
     * @param parcelClass the class of the parcel
     * @return a list with all currently in the {@link tomconn.growthapi.base.handler.IEventHandler}s of this
     * {@link tomconn.growthapi.base.manager.IEventManager} registered processors which match the provided class
     */
    <P extends IEventParcel<E>, E extends Event> List<ICompositeEventProcessor<E, P>>
    retrieveProcessorsMatching(Class<P> parcelClass);


    /**
     * Returns a list of handlers in which this processor is registered
     *
     * @param processor the processor
     * @return <ul>
     * <li>a {@link List} of {@link tomconn.growthapi.base.handler.IEventHandler}
     * <ul>
     * <li>in case this processor was found to be registered on one or more in this EventManager
     * registered EventHandlers</li>
     * </ul>
     * </li>
     * <li>null
     * <ul>
     * <li>in case there is no registered handler which has the processor registered</li>
     * </ul>
     * </li>
     * </ul>
     */
    <
            X extends ICompositeEventProcessor<E, P>,
            E extends Event,
            P extends IEventParcel<E>
            >
    List<IEventHandler<E, X>>
    getRegisteringHandlersForProcessor(ICompositeEventProcessor<E, P> processor);


    /**
     * Registers a processor within an eligible {@link IEventHandler} in case there is one present which accepts
     * the passed processor and the respective event
     *
     * @param processor       the process you wish to register anywhere within this EventManager
     * @param fallbackHandler a fallback handler which is used in case there is currently no EventHandler
     *                        present which accepts both the processor and the event
     * @param eventClass      the class of the event
     * @param <E>             the Event
     * @param <X>             the Processor
     * @return <ul>
     * <li>
     * an {@link IEventHandler}
     * <ul>
     * <li>
     * if and only if there was a handler registered, which accepted both the processor
     * and the event
     * <br>
     * <br>
     * <b>Attention:</b>
     * <br>If there was no other handler present to accept the processor, the fallbackHandler will be returned
     * </li>
     * </ul>
     * </li>
     *
     * <li>null
     * <ul>
     * <li>if the processor could not be registered </li>
     * </ul>
     * </li>
     * </ul>
     */
    <
            E extends Event,
            X extends ICompositeEventProcessor<E, ? extends IEventParcel<E>>
            >
    IEventHandler<E, X>
    registerProcessor(X processor, Class<E> eventClass, IEventHandler<E, X> fallbackHandler);


}
