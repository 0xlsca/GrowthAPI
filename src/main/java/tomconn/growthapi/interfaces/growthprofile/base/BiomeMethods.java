package tomconn.growthapi.interfaces.growthprofile.base;


import net.minecraft.world.biome.Biome;
import tomconn.growthapi.interfaces.growthprofile.BaseGrowthProfile;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Provides methods for white- or blacklisting {@link Biome Biomes}
 *
 * @param <P>
 *
 * @since 0.0.6
 */
public interface BiomeMethods< P extends BaseGrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * Returns the currently registered whitelisted {@link Biome Biomes} in the form of a {@link Stream}
     *
     * @return the whitelisted {@link Biome Biomes}
     *
     * @since 0.0.6
     */
    Stream< Biome > getWhitelistedBiomes();


    /**
     * Returns the currently registered blacklisted {@link Biome Biomes} in the form of a {@link Stream}
     *
     * @return the blacklisted {@link Biome Biomes}
     *
     * @since 0.0.6
     */
    Stream< Biome > getBlacklistedBiomes();


    /**
     * Replaces the currently help whitelisted {@link Biome Biomes} with the passed ones in the {@link Collection}
     *
     * @param biomes the biomes which shall replace the currently registered ones
     *
     * @since 0.0.6
     */
    void setWhitelistedBiomes(Collection< Biome > biomes);


    /**
     * Vararg-wrapper for {@link #setWhitelistedBiomes(Collection)}
     *
     * @param biomes the biomes to set
     *
     * @see #setWhitelistedBiomes(Collection)
     * @since 0.0.6
     */
    default void setWhitelistedBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        setWhitelistedBiomes(Arrays.asList(biomes));
    }


    /**
     * Chaining-method for {@link #setWhitelistedBiomes(Collection)}
     *
     * @param biomes the biomes to set
     *
     * @return this instance, for chaining purposes
     *
     * @see #setWhitelistedBiomes(Collection)
     * @since 0.0.6
     */
    default P whitelistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        setWhitelistedBiomes(biomes);
        return getThis();
    }


    /**
     * Vararg-wrapper for {@link #whitelistBiomes(Collection)}
     *
     * @param biomes the biomes
     *
     * @return this instance, for chaining purposes
     *
     * @see #whitelistBiomes(Biome...)
     * @since 0.0.6
     */
    default P whitelistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return whitelistBiomes(Arrays.asList(biomes));
    }


    /**
     * Replaces the currently help blacklisted {@link Biome Biomes} with the passed ones in the {@link Collection}
     *
     * @param biomes the biomes which shall replace the currently registered ones
     *
     * @since 0.0.6
     */
    void setBlacklistedBiomes(Collection< Biome > biomes);


    /**
     * Vararg wrapper for {@link #setBlacklistedBiomes(Collection)}
     *
     * @see #setBlacklistedBiomes(Collection)
     * @since 0.0.6
     */
    default void setBlacklistedBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        setBlacklistedBiomes(Arrays.asList(biomes));
    }


    /**
     * Chaining-wrapper for {@link #setBlacklistedBiomes(Collection)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setBlacklistedBiomes(Collection)
     * @since 0.0.6
     */
    default P blacklistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        setBlacklistedBiomes(biomes);
        return getThis();
    }


    /**
     * A vararg-wrapper for {@link #blacklistBiomes(Collection)}
     *
     * @see #blacklistBiomes(Collection)
     * @since 0.0.6
     */
    default P blacklistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return blacklistBiomes(Arrays.asList(biomes));
    }


    /**
     * Adds the passed {@link Biome Biomes} to the currently held whitelisted ones
     *
     * @param biomes the biomes which shall be added
     *
     * @since 0.0.6
     */
    void addWhitelistedBiomes(Collection< Biome > biomes);


    /**
     * Vararg wrapper for {@link #addWhitelistedBiomes(Collection)}
     *
     * @see #addWhitelistedBiomes(Collection)
     * @since 0.0.6
     */
    default void addWhitelistedBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        addWhitelistedBiomes(Arrays.asList(biomes));
    }


    /**
     * Chaining-wrapper for {@link #addWhitelistedBiomes(Collection)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #addWhitelistedBiomes(Collection)
     * @since 0.0.6
     */
    default P addWhitelistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        addBlacklistBiomes(biomes);
        return getThis();
    }


    /**
     * A vararg-wrapper for {@link #addWhitelistBiomes(Collection)}
     *
     * @see #addWhitelistBiomes(Collection)
     * @since 0.0.6
     */
    default P addWhitelistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return addWhitelistBiomes(Arrays.asList(biomes));
    }


    /**
     * Adds the passed {@link Biome Biomes} to the currently held blacklisted ones
     *
     * @param biomes the biomes which shall be added
     *
     * @since 0.0.6
     */
    void addBlacklistedBiomes(Collection< Biome > biomes);


    /**
     * Vararg wrapper for {@link #addBlacklistedBiomes(Collection)}
     *
     * @see #addBlacklistedBiomes(Collection)
     * @since 0.0.6
     */
    default void addBlacklistedBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        addBlacklistedBiomes(Arrays.asList(biomes));
    }


    /**
     * Chaining-wrapper for {@link #addBlacklistedBiomes(Collection)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #addBlacklistedBiomes(Collection)
     * @since 0.0.6
     */
    default P addBlacklistBiomes(Collection< Biome > biomes) {

        Objects.requireNonNull(biomes);
        addBlacklistedBiomes(biomes);
        return getThis();
    }


    /**
     * A vararg-wrapper for {@link #addBlacklistBiomes(Collection)}
     *
     * @see #addBlacklistBiomes(Collection)
     * @since 0.0.6
     */
    default P addBlacklistBiomes(Biome... biomes) {

        Objects.requireNonNull(biomes);
        return addBlacklistBiomes(Arrays.asList(biomes));
    }

}
