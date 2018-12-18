package tomconn.growthapi.implementations.eventhelpers;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;

/**
 * This is a utility class which shall help with retrieving information from
 * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} events.
 * <p>
 * Please note that every helper is bound to be tied to exactly one event, so in case you have multiple events,
 * each of them will require a dedicated event-helper.
 */
public class CropGrowPostEventHelper {

    protected final BlockEvent.CropGrowEvent.Post event;

    public CropGrowPostEventHelper(BlockEvent.CropGrowEvent.Post event) {
        this.event = event;
    }

    /**
     * Returns the class of the block which triggered the event.
     *
     * @return the block's class
     */
    public Class<? extends Block> getBlockClass() {
        return event.getState().getBlock().getClass();
    }


}
