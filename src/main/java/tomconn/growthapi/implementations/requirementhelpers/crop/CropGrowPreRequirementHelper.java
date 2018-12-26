package tomconn.growthapi.implementations.requirementhelpers.crop;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.requirementhelpers.ABaseRequirementHelper;


/**
 * This class provides utility for the creation of growth requirements of crops.
 */
public class CropGrowPreRequirementHelper extends ABaseRequirementHelper<Pre> {


    @Override
    protected boolean supplyBlockCanSeeSkyFromEvent(Pre event) {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }

    @Override
    protected float supplyBiomeBasedTemperatureFromEvent(Pre event) {
        return supplyBiomeFromEvent(event).getTemperature(event.getPos());
    }

    @Override
    protected Biome supplyBiomeFromEvent(Pre event) {
        return event.getWorld().getBiome(event.getPos());
    }

    @Override
    protected int supplyLightLevelFromEvent(Pre event) {
        return event.getWorld().getLight(event.getPos());
    }
}