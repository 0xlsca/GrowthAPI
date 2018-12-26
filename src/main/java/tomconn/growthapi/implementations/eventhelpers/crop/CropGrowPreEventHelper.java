package tomconn.growthapi.implementations.eventhelpers.crop;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.eventhelpers.ABaseEventHelper;

/**
 * This is a utility class which shall help with retrieving information from
 * {@link Pre} events.
 * <p>
 * Please note that every helper is bound to be tied to exactly one event, so in case you have multiple events,
 * each of them will require a dedicated event-helper.
 */
public class CropGrowPreEventHelper extends ABaseEventHelper<Pre> {


    public CropGrowPreEventHelper(Pre event) {
        super(event);
    }

    @Override
    public Class<? extends Block> getBlockClass() {
        return event.getState().getBlock().getClass();
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
