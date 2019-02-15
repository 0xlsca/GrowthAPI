package tomconn.growthapi.implementations.event.helper;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import tomconn.growthapi.interfaces.event.helper.base_information.BlockClassProvider;

/**
 * This is a utility class which shall help with retrieving information from
 * {@link CropGrowEvent.Post} events.
 * <p>
 * Please note that every helper is bound to be tied to exactly one event, so in case you have multiple events,
 * each of them will require a dedicated event-helper.
 *
 * @since 0.0.5
 */
@Deprecated
public class CropGrowPostEventHelper implements BlockClassProvider {

    protected final BlockEvent.CropGrowEvent.Post event;

    public CropGrowPostEventHelper(BlockEvent.CropGrowEvent.Post event) {
        this.event = event;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    public Class<? extends Block> getBlockClass() {
        return event.getState().getBlock().getClass();
    }


}
