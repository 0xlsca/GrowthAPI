package tomconn.growthapi.interfaces.requirementhelpers.base_requirements;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Provides methods which help with tailoring {@link GrowthCondition GrowthConditions} which only allow or disallow
 * certain {@link Biome Biomes}
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface BiomeRequirements< E extends Event > extends BaseRequirement< E > {

    /**
     * A vararg-wrapper for {@link #whitelistBiomes(Collection)}
     *
     * @see #whitelistBiomes(Collection)
     * @since 0.0.6
     */
    default GrowthCondition< E > whitelistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return whitelistBiomes(Arrays.asList(biomes));
    }


    /**
     * Returns a {@link GrowthCondition} which makes sure that a block only grows if it is within one of the passed
     * {@link Biome Biomes}
     *
     * @param biomes the whitelisted biomes
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > whitelistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        return e -> biomes.contains(supplyHelper(e).getBiome());
    }


    /**
     * A vararg-wrapper for {@link #blacklistBiomes(Collection)}
     *
     * @see #blacklistBiomes(Collection)
     * @since 0.0.6
     */
    default GrowthCondition< E > blacklistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return blacklistBiomes(Arrays.asList(biomes));
    }


    /**
     * Returns a {@link GrowthCondition} which makes sure that a block only grows if it is <b><u>not </u></b>within one
     * of the passed {@link Biome Biomes}
     *
     * @param biomes the blacklisted biomes
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > blacklistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        return whitelistBiomes(biomes).negate();
    }

}
