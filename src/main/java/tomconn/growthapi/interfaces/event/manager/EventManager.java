package tomconn.growthapi.interfaces.event.manager;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.registry.UnifiedRegistry;

/**
 * An DefaultEventManager is supposed to handle passed events without causing exceptions.
 *
 * @since 0.0.6
 */
public interface EventManager {

    /**
     * Manages a {@link Pre} event
     *
     * @param event the event instance
     *
     * @since 0.0.6
     */
    void manage(Pre event);


    /**
     * Manages a {@link SaplingGrowTreeEvent}
     *
     * @param event the event instance
     *
     * @since 0.0.6
     */
    void manage(SaplingGrowTreeEvent event);


    /**
     * Manages a {@link Post} event
     *
     * @param event the event instance
     *
     * @since 0.0.6
     */
    void manage(Post event);


    /**
     * Returns the internally held {@link UnifiedRegistry}
     *
     * @return the registry
     *
     * @since 0.0.6
     */
    UnifiedRegistry getUnifiedRegistry();

}
