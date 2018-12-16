package tomconn.growthapi.prepackaged;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.handler.IEventHandler;
import tomconn.growthapi.base.manager.IEventManager;
import tomconn.growthapi.base.parcel.IEventParcel;
import tomconn.growthapi.base.processor.EasyProcessorAPIForManager;
import tomconn.growthapi.base.processor.ICompositeEventProcessor;

import javax.annotation.Nullable;
import java.util.*;


/**
 * This is a default-implementation of the {@link IEventManager} interface. It is a singleton.
 */
public class DefaultEventManager implements EasyProcessorAPIForManager {

    private Map<Class<? extends Event>, IEventHandler<?, ?>> handlers = new HashMap<>();

    private final static DefaultEventManager instance = new DefaultEventManager();

    private DefaultEventManager() {
    }

    public static DefaultEventManager getInstance() {
        return instance;
    }

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

    @SuppressWarnings("unchecked")
    @Override
    public <P extends IEventParcel<E>, E extends Event> List<ICompositeEventProcessor<E, P>> retrieveProcessorsMatching(Class<E> eventClass, Class<P> parcelClass) {
        List<ICompositeEventProcessor<E, P>> returnList = new ArrayList();

        handlers.values().forEach(handler -> {
            if (handler.canHandle(eventClass)) {

                IEventHandler<E, ?> eligibleHandler = (IEventHandler<E, ?>) handler;
                eligibleHandler.getEligibleProcessors(eventClass).forEach(processor -> {
                    if (processor.canProcess(eventClass) && processor.isEligible(parcelClass)) {
                        returnList.add((ICompositeEventProcessor<E, P>) processor);
                    }
                });
            }
        });

        return returnList;
    }

    @Override
    public <P extends IEventParcel<E>, E extends Event> List<ICompositeEventProcessor<E, P>> retrieveProcessorsMatching(Class<P> parcelClass) {
        List<ICompositeEventProcessor<E, P>> returnList = new ArrayList<>();


        handlers.values().forEach(handler -> {
            returnList.addAll(handler.getEligibleProcessorsByParcel(parcelClass));
        });

        return returnList;
    }

    @Override
    public <X extends ICompositeEventProcessor<E, P>, E extends Event, P extends IEventParcel<E>> List<IEventHandler<E, X>> getRegisteringHandlersForProcessor(ICompositeEventProcessor<E, P> processor) {

    }

    @Override
    public <E extends Event, X extends ICompositeEventProcessor<E, ? extends IEventParcel<E>>> IEventHandler<E, X> registerProcessor(X processor, Class<E> eventClass, IEventHandler<E, X> fallbackHandler) {

    }
}
