package tomconn.growthapi.implementations.eventhelpers;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Defines basic methods which can be supported by both events (
 * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} and
 * {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent} )
 */
public abstract class ABaseEventHelper<E extends Event> {

    protected E event;

    public ABaseEventHelper(E event) {
        this.event = event;
    }

    /**
     * Returns the class of the block which triggered the event.
     *
     * @return the block's class
     */
    public abstract Class<? extends Block> getBlockClass();

    /**
     * Returns whether the triggering block can see the sky
     *
     * @return true iof the block has a line of sight to the sky, false otherwise
     */
    public abstract boolean canSeeSky();


    /**
     * Returns the {@link Biome} the block is located in
     *
     * @return the {@link Biome} in which the block is located
     */
    public abstract Biome getBiome();


    /**
     * Returns the current temperature of the block in dependence of the {@link Biome} it is located in
     *
     * @return the {@link Biome}-based temperature of the block
     */
    public abstract float getBlockTemperature();

    /**
     * Returns the light-level of the block. Please note that this is the fixed light-level and therefor is
     * unaffected by the day-night-cycle
     *
     * @return the day-night-cycle independent light-level of the block
     */
    public abstract int getLightLevel();
}
