package tomconn.growthapi.implementations.eventhelpers;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

/**
 * This class is a utility class and helps with retrieving information from
 * {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}s.
 * <p>
 * Please note that each helper may only be assigned to one event, meaning you are required to instantiate a new
 * helper for a new event.
 */
public class SaplingGrowTreeEventHelper {

    protected final SaplingGrowTreeEvent event;

    public SaplingGrowTreeEventHelper(SaplingGrowTreeEvent event) {
        this.event = event;
    }

    /**
     * Returns the class of the block which triggered the event.
     *
     * @return the triggering block's class
     */
    public Class<? extends Block> getBlockClass() {
        World world = event.getWorld();
        IBlockState blockState = world.getBlockState(event.getPos());
        return blockState.getBlock().getClass();
    }


}
