package tomconn.growthapi.implementations.requirementhelpers.sapling;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.requirementhelpers.PrimitiveRequirementHelper;

import javax.annotation.Nonnull;

/**
 * Helps with tailoring requirements for the {@link SaplingGrowTreeEvent}
 */
public class SaplingGrowTreeRequirementHelper extends PrimitiveRequirementHelper< SaplingGrowTreeEvent > {


    @Override
    protected boolean supplyBlockCanSeeSkyFromEvent(@Nonnull SaplingGrowTreeEvent event) {
        return event.getWorld().canBlockSeeSky(event.getPos());
    }

    @Override
    protected float supplyBiomeBasedTemperatureFromEvent(@Nonnull SaplingGrowTreeEvent event) {
        return supplyBiomeFromEvent(event).getTemperature(event.getPos());
    }


    @Nonnull
    @Override
    protected Biome supplyBiomeFromEvent(@Nonnull SaplingGrowTreeEvent event) {

        return event.getWorld().getBiome(event.getPos());
    }

    @Override
    protected int supplyLightLevelFromEvent(@Nonnull SaplingGrowTreeEvent event) {
        return event.getWorld().getLight(event.getPos());
    }
}
