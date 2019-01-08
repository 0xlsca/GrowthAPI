package tomconn.growthapi.interfaces.event.helpers.base_information;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * This interface helps with providing the {@link World} in which an event takes place
 *
 * @since 0.0.6
 */
public interface WorldProvider {

    /**
     * Returns the {@link World} which is associated with the event
     *
     * @return the world in which the {@link Event} takes place
     *
     * @since 0.0.6
     */
    World getWorld();

}
