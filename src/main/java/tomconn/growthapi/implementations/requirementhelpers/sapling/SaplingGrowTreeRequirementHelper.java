package tomconn.growthapi.implementations.requirementhelpers.sapling;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.requirementhelpers.ABaseRequirementHelper;

/**
 * Helps with tailoring requirements for the {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}
 */
public class SaplingGrowTreeRequirementHelper extends ABaseRequirementHelper<SaplingGrowTreeEvent> {


    @Override
    protected boolean supplyBlockCanSeeSkyFromEvent(SaplingGrowTreeEvent event) {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }

    @Override
    protected float supplyBiomeBasedTemperatureFromEvent(SaplingGrowTreeEvent event) {
        return supplyBiomeFromEvent(event).getTemperature(event.getPos());
    }

    @Override
    protected Biome supplyBiomeFromEvent(SaplingGrowTreeEvent event) {
        return event.getWorld().getBiome(event.getPos());
    }

    @Override
    protected int supplyLightLevelFromEvent(SaplingGrowTreeEvent event) {
        return event.getWorld().getLight(event.getPos());
    }
}
