package tomconn.growthapi.base;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.decision_logic_unit.IEventFutureDecisionLogicUnit;
import tomconn.growthapi.base.handler.IEventHandler;
import tomconn.growthapi.base.manager.IEventManager;
import tomconn.growthapi.base.processor.ICompositeEventProcessor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class IEventManagerTestImplementations {

    public static class TestEventManager extends IEventManagerDefaultImplTest implements IEventManager {

        Map<Class<?>, IEventHandler<?, ?>> handlerRegistry = new HashMap<>();

        @Override
        public <E extends Event> boolean registerEventHandler(IEventHandler<E, ?> handler, Class<E> eventClass) {
            return handlerRegistry.put(eventClass, handler) == null;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <E extends Event> List<IEventHandler<E, ?>> unregisterEventHandler(@Nullable IEventHandler<E, ?> handler, @Nullable Class<E> eventClass) {
            List<Class<E>> keyList = new ArrayList<>();
            if (handler != null) {


                handlerRegistry.forEach((key, value) -> {
                    if (value == handler) {
                        keyList.add((Class<E>) key);
                    }
                });


            }
            if (eventClass != null && handlerRegistry.keySet().contains(eventClass)) {
                keyList.add(eventClass);
            }

            return keyList.stream()
                    .map(c -> (IEventHandler<E, ?>) handlerRegistry.remove(c))
                    .collect(Collectors.toList());
        }

        @Override
        public List<IEventHandler> getAllHandlers() {
            return Collections.unmodifiableList(new ArrayList<>(handlerRegistry.values()));
        }

        @Override
        IEventManager getInstance() {
            return new TestEventManager();
        }
    }

    public static class TestEventHandlerPre implements IEventHandler<BlockEvent.CropGrowEvent.Pre, ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, ?>> {
        @Override
        public boolean canHandle(@Nonnull Class<BlockEvent.CropGrowEvent.Pre> eventclass) {
            return eventclass == BlockEvent.CropGrowEvent.Pre.class;
        }

        @Override
        public boolean registerProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, ?> processor) {
            return false;
        }

        @Override
        public boolean removeProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, ?> processor) {
            return false;
        }

        @Override
        public boolean hasProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, ?> processor) {
            return false;
        }

        @Override
        public List<ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, ?>> getProcessors() {
            return null;
        }

        @Override
        public boolean setEventFutureDecisionLogicUnit(@Nonnull IEventFutureDecisionLogicUnit decisionMaker) {
            return false;
        }

        @Override
        public IEventFutureDecisionLogicUnit getEventFutureDecisionLogicUnit() {
            return null;
        }
    }

    public static class TestEventHandlerPost implements IEventHandler<BlockEvent.CropGrowEvent.Post, ICompositeEventProcessor<BlockEvent.CropGrowEvent.Post, ?>> {
        @Override
        public boolean canHandle(@Nonnull Class<BlockEvent.CropGrowEvent.Post> eventclass) {
            return eventclass == BlockEvent.CropGrowEvent.Post.class;
        }

        @Override
        public boolean registerProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Post, ?> processor) {
            return false;
        }

        @Override
        public boolean removeProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Post, ?> processor) {
            return false;
        }

        @Override
        public boolean hasProcessor(@Nonnull ICompositeEventProcessor<BlockEvent.CropGrowEvent.Post, ?> processor) {
            return false;
        }

        @Override
        public List<ICompositeEventProcessor<BlockEvent.CropGrowEvent.Post, ?>> getProcessors() {
            return null;
        }

        @Override
        public boolean setEventFutureDecisionLogicUnit(@Nonnull IEventFutureDecisionLogicUnit decisionMaker) {
            return false;
        }

        @Override
        public IEventFutureDecisionLogicUnit getEventFutureDecisionLogicUnit() {
            return null;
        }
    }
}
