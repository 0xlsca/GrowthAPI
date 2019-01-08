package tomconn.growthapi.interfaces.event.helpers.base_information;

import net.minecraft.world.biome.Biome;

public interface TemperatureProvider {

    /**
     * Returns the current temperature of the block in dependence of the {@link Biome} it is located in
     *
     * @return the {@link Biome}-based temperature of the block
     *
     * @since 0.0.6
     */
    float getTemperature();

}
