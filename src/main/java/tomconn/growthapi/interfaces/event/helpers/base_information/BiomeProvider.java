package tomconn.growthapi.interfaces.event.helpers.base_information;

import net.minecraft.world.biome.Biome;

public interface BiomeProvider {

    /**
     * Returns the {@link Biome} the block is located in
     *
     * @return the {@link Biome} in which the block is located
     *
     * @since 0.0.6
     */
    Biome getBiome();


}
