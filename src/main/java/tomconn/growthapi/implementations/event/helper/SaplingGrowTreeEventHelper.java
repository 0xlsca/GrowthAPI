package tomconn.growthapi.implementations.event.helper;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

import javax.annotation.Nonnull;

/**
 * This class is a utility class and helps with retrieving information from
 * {@link SaplingGrowTreeEvent}s.
 * <p>
 * Please note that each helper may only be assigned to one event, meaning you are required to instantiate a new
 * helper for a new event.
 *
 * @since 0.0.5
 */
class SaplingGrowTreeEventHelper extends AbstractBaseEventHelper< SaplingGrowTreeEvent > {

    /**
     * Default constructor
     *
     * @param event an instance of {@link SaplingGrowTreeEvent}
     *
     * @since 0.0.5
     */
    public SaplingGrowTreeEventHelper(SaplingGrowTreeEvent event) {

        super(event);
    }


    /**
     * Returns the class of the block which triggered the event.
     *
     * @return the triggering block's class
     *
     * @since 0.0.5
     */
    public Class< ? extends Block > getBlockClass() {

        World world = event.getWorld();
        IBlockState blockState = world.getBlockState(event.getPos());
        return blockState.getBlock().getClass();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean canSeeSky() {

        return event.getWorld().canBlockSeeSky(event.getPos());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Nonnull
    @Override
    public Biome getBiome() {

        return event.getWorld().getBiome(event.getPos());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public float getTemperature() {

        return getBiome().getTemperature(event.getPos());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public int getLightLevel() {

        return event.getWorld().getLight(event.getPos());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public BlockPos getBlockBos() {

        return event.getPos();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public World getWorld() {

        return event.getWorld();
    }

}
