package tomconn.growthapi.base;

import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SuppressWarnings("WeakerAccess")
abstract class IEventManagerDefaultImplTest {

    IEventManager manager;

    IEventHandler<BlockEvent.CropGrowEvent.Pre, ?> handlerPre = new IEventManagerTestImplementations.TestEventHandlerPre();

    IEventHandler<BlockEvent.CropGrowEvent.Post, ?> handlerPost = new IEventManagerTestImplementations.TestEventHandlerPost();

    abstract IEventManager getInstance();

    @BeforeEach
    void before() {

        if (manager == null) {
            manager = getInstance();
        }

        List<IEventHandler> handlers = manager.getAllHandlers();

        if (!handlers.contains(handlerPre))
            manager.registerEventHandler(handlerPre, BlockEvent.CropGrowEvent.Pre.class);
        if (!handlers.contains(handlerPost))
            manager.registerEventHandler(handlerPost, BlockEvent.CropGrowEvent.Post.class);
        if (!handlers.contains(null)) manager.registerEventHandler(null, null);
    }


    @Test
    void getHandlerForEvent() {

        assertEquals(handlerPre, manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Pre.class));
        assertEquals(handlerPost, manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Post.class));
        assertNull(manager.getHandlerForEvent(null));
        assertNull(manager.getHandlerForEvent(ArrowNockEvent.class));

    }

    @Test
    void unregisterEventHandlerClass() {

        assertEquals(handlerPre, manager.unregisterEventHandler(BlockEvent.CropGrowEvent.Pre.class));
        assertEquals(handlerPost, manager.unregisterEventHandler(BlockEvent.CropGrowEvent.Post.class));

        assertNull(manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Pre.class));
        assertNull(manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Post.class));


    }

    @Test
    void unregisterEventHandlerHandler() {
        assert manager.unregisterEventHandler(handlerPre);
        assert manager.unregisterEventHandler(handlerPost);

        assertNull(manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Pre.class));
        assertNull(manager.getHandlerForEvent(BlockEvent.CropGrowEvent.Post.class));

        assertNull(manager.getHandlerForEvent(null));
        assertNull(manager.getHandlerForEvent(ArrowNockEvent.class));

        manager.unregisterEventHandler((Class<Event>) null);
        manager.unregisterEventHandler(ArrowNockEvent.class);

        assertNull(manager.getHandlerForEvent(null));
        assertNull(manager.getHandlerForEvent(ArrowNockEvent.class));

    }

    @Test
    void hasHandlerFor() {
        manager.registerEventHandler(null, ArrowNockEvent.class);

        assertFalse(manager.hasHandlerFor(ArrowNockEvent.class));
        assertTrue(manager.hasHandlerFor(BlockEvent.CropGrowEvent.Pre.class));
        assertTrue(manager.hasHandlerFor(BlockEvent.CropGrowEvent.Post.class));
        assertFalse(manager.hasHandlerFor(null));

        assertNull(manager.unregisterEventHandler((Class<Event>) null));

        assertFalse(manager.hasHandlerFor(null));
    }

    @Test
    void manage() {

        assertTrue(manager.hasHandlerFor(BlockEvent.CropGrowEvent.Pre.class));

        //this should always and in all implementations return false.
        assertFalse(manager.manage(null));

    }
}