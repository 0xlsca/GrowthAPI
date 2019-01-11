package tomconn.growthapi.implementations.event.helpers.crop;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.event.helpers.PrimitiveEventHelper;

import javax.annotation.Nonnull;

/**
 * This is a utility class which shall help with retrieving information from
 * {@link Pre} events.
 * <p>
 * Please note that every helper is bound to be tied to exactly one event, so in case you have multiple events,
 * each of them will require a dedicated event-helper.
 *
 * @since 0.0.5
 */
public class CropGrowPreEventHelper extends PrimitiveEventHelper< Pre > {


    /**
     * Default constructor
     *
     * @param event an instance of {@link Pre}
     *
     * @since 0.0.5
     */
    public CropGrowPreEventHelper(Pre event) {

        super(event);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Class< ? extends Block > getBlockClass() {

        return event.getState().getBlock().getClass();
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
