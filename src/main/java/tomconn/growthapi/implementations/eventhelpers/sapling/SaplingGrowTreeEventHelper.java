package tomconn.growthapi.implementations.eventhelpers.sapling;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.eventhelpers.ABaseEventHelper;

/**
 * This class is a utility class and helps with retrieving information from
 * {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}s.
 * <p>
 * Please note that each helper may only be assigned to one event, meaning you are required to instantiate a new
 * helper for a new event.
 */
public class SaplingGrowTreeEventHelper extends ABaseEventHelper<SaplingGrowTreeEvent> {

    public SaplingGrowTreeEventHelper(SaplingGrowTreeEvent event) {
        super(event);
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

    @Override
    public boolean canSeeSky() {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }

    @Override
    public Biome getBiome() {
        return event.getWorld().getBiome(event.getPos());
    }

    @Override
    public float getBlockTemperature() {
        return getBiome().getTemperature(event.getPos());
    }

    @Override
    public int getLightLevel() {
        return event.getWorld().getLight(event.getPos());
    }


}
