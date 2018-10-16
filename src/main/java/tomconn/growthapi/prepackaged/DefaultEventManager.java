package tomconn.growthapi.prepackaged;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.IEventHandler;
import tomconn.growthapi.base.IEventManager;

import javax.annotation.Nullable;
import java.util.*;


/**
 * This is a default-implementation of the {@link IEventManager} interface
 */
public class DefaultEventManager implements IEventManager {

    private Map<Class<? extends Event>, IEventHandler<?, ?>> handlers = new HashMap<>();


    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Event> boolean registerEventHandler(IEventHandler<E, ?> handler, Class<E> eventClass) {
        if (this.hasHandlerFor(eventClass)) {
            return false;
        }

        handlers.put(eventClass, handler);

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends Event> List<IEventHandler<E, ?>> unregisterEventHandler(@Nullable IEventHandler<E, ?> handler, @Nullable Class<E> eventClass) {

        if (handler != null) {

            if (handlers.values().contains(handler)) {
                Optional<Map.Entry<Class<? extends Event>, IEventHandler<?, ?>>> first = handlers.entrySet().stream().filter(s -> s.getValue() == handler).findFirst();
                if (first.isPresent()) {
                    return Collections.singletonList((IEventHandler<E, ?>) handlers.remove(first.get().getKey()));
                }
            }
        }

        if (eventClass != null) {
            if (handlers.keySet().stream().anyMatch(c -> c == eventClass)) {
                return Collections.singletonList((IEventHandler<E, ?>) handlers.remove(eventClass));
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IEventHandler> getAllHandlers() {
        return Collections.unmodifiableList(new ArrayList<>(handlers.values()));
    }
}
