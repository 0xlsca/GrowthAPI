package tomconn.growthapi.base.manager;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.handler.IEventHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classes implementing this interface are supposed to handle the passed events in the respective method.
 */
public interface IEventManager {


    /**
     * Returns the handler for the specified event
     *
     * @param e   then event class
     * @param <E> Any variation of {@link Event}
     * @return The registered {@link IEventHandler} for {@code e}
     */
    @SuppressWarnings({"unchecked"})
    default <E extends Event> IEventHandler<E, ?> getHandlerForEvent(Class<E> e) {
        List<IEventHandler> handler = this.getAllHandlers()
                .stream()
                .filter(h -> h != null && h.canHandle(e))
                .collect(Collectors.toList());
        return handler.size() != 0 ? handler.get(0) : null;
    }


    /**
     * Registers a new handler for the given {@link Event} if there isn't already one registered
     *
     * @param handler    the handler
     * @param eventClass then class of the event
     * @param <E>        the {@link Event}
     * @return true if the handler was successfully registered, false if not so
     */
    <E extends Event> boolean registerEventHandler(IEventHandler<E, ?> handler, Class<E> eventClass);

    /**
     * Tries to unregister a present handler based on the passed handler reference.
     *
     * @param handler An instance of {@link IEventHandler}
     * @param <E>     Any variation of {@link Event}
     * @return True if and only if the passed instance was registered in this {@link IEventManager}
     * and it was successfully removed, false otherwise
     */
    default <E extends Event> boolean unregisterEventHandler(IEventHandler<E, ?> handler) {
        return this.unregisterEventHandler(handler, null) != null;
    }

    /**
     * Tries to unregister one present handler based on the passed event-class.
     *
     * @param eventClass The event-class of which a present handler shall be removed
     * @param <E>        Any variation of {@link Event}
     * @return The registered event-handler if and only if there was a handler registered for the passed class
     * <br> null otherwise
     */
    default <E extends Event> IEventHandler<E, ?> unregisterEventHandler(Class<E> eventClass) {

        List<IEventHandler<E, ?>> ret = this.unregisterEventHandler(null, eventClass);

        return ret == null ? null : (ret.size() != 0 ? ret.get(0) : null);
    }

    /**
     * Tries to unregister a present handler based on the passed handler reference. <br>
     * If there is no such handler, the currently for {@code eventClass} registered handler will be unregistered
     *
     * @param <E>        Any variation of {@link Event}
     * @param handler    An instance of {@link IEventHandler}
     * @param eventClass An class derived by {@link Event}
     * @return The respective unregistered handler, null if there was no handler registered for the class
     */
    <E extends Event> List<IEventHandler<E, ?>> unregisterEventHandler(@Nullable IEventHandler<E, ?> handler, @Nullable Class<E> eventClass);


    /**
     * Handles Forge Events
     *
     * @param event the event
     * @param <E>   any variation of {@link Event}
     * @return <ul>
     * <li>
     * <code>true</code>
     * <ul>
     * <li>
     * if and only if the event was successfully passed to a handler,
     * which in turn successfully handled the event
     * </li>
     * </ul>
     * </li>
     * <li>
     * <code>false</code>
     * <ul>
     * <li>if <code>event</code> was null</li>
     * <li>in all other cases</li>
     * </ul>
     * </li>
     * </ul>
     */
    @SuppressWarnings("unchecked")
    default <E extends Event> boolean manage(E event) {
        if (event != null) {
            IEventHandler<E, ?> handler = this.getHandlerForEvent((Class<E>) event.getClass());
            if (handler != null) {
                return handler.handleEvent(event);
            }
        }
        return false;
    }

    /**
     * Returns an <b>unmodifiable</b> list with all currently registered handlers
     *
     * @return an <b>unmodifiable</b> list of all currently registered {@link IEventHandler}
     */
    List<IEventHandler> getAllHandlers();

    /**
     * Checks whether there is already a {@link IEventHandler} which handles instances of the passed event class
     *
     * @param eventclass the class of the event
     * @param <E>        any variation of {@link Event}
     * @return <ul>
     * <li>
     * <code>true</code> if there was a class <b>and</b> a respective handler registered, meaning the <b>handler</b> was <b>not</b> <code>null</code>
     * </li>
     * <li>
     * <code>false</code> in all other cases
     * </li>
     * </ul>
     */
    @SuppressWarnings("unchecked")
    default <E extends Event> boolean hasHandlerFor(Class<E> eventclass) {
        return this.getAllHandlers()
                .stream()
                .anyMatch(h -> h != null && h.canHandle(eventclass));
    }

}
