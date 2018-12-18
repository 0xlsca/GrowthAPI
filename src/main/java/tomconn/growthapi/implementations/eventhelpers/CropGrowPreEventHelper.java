package tomconn.growthapi.implementations.eventhelpers;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;

/**
 * This is a utility class which shall help with retrieving information from
 * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} events.
 * <p>
 * Please note that every helper is bound to be tied to exactly one event, so in case you have multiple events,
 * each of them will require a dedicated event-helper.
 */
public class CropGrowPreEventHelper {

    protected final BlockEvent.CropGrowEvent.Pre event;

    public CropGrowPreEventHelper(BlockEvent.CropGrowEvent.Pre event) {
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

    /**
     * Returns whether the triggering block can see the sky
     *
     * @return true iof the block has a line of sight to the sky, false otherwise
     */
    public boolean canSeeSky() {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }


    /**
     * Returns the {@link Biome} the block is located in
     *
     * @return the {@link Biome} in which the block is located
     */
    public Biome getBiome() {
        return event.getWorld().getBiome(event.getPos());
    }


    /**
     * Returns the current temperature of the block in dependence of the {@link Biome} it is located in
     *
     * @return the {@link Biome}-based temperature of the block
     */
    public float getBlockTemperature() {
        return getBiome().getTemperature(event.getPos());
    }

    /**
     * Returns the light-level of the block. Please note that this is the fixed light-level and therefor is
     * unaffected by the day-night-cycle
     *
     * @return the day-night-cycle independent light-level of the block
     */
    public int getLightLevel() {
        return event.getWorld().getLight(event.getPos());
    }

}
