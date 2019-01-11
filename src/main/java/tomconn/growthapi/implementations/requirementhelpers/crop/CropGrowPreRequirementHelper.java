package tomconn.growthapi.implementations.requirementhelpers.crop;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.requirementhelpers.PrimitiveRequirementHelper;

import javax.annotation.Nonnull;


/**
 * This class provides utility for the creation of growth requirements of crops.
 */
public class CropGrowPreRequirementHelper extends PrimitiveRequirementHelper< Pre > {


    @Override
    protected boolean supplyBlockCanSeeSkyFromEvent(@Nonnull Pre event) {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }

    @Override
    protected float supplyBiomeBasedTemperatureFromEvent(@Nonnull Pre event) {
        return supplyBiomeFromEvent(event).getTemperature(event.getPos());
    }


    @Nonnull
    @Override
    protected Biome supplyBiomeFromEvent(@Nonnull Pre event) {

        return event.getWorld().getBiome(event.getPos());
    }

    @Override
    protected int supplyLightLevelFromEvent(@Nonnull Pre event) {
        return event.getWorld().getLight(event.getPos());
    }
}