package tomconn.growthapi.implementations.growthprofile;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tomconn.growthapi.implementations.growthprofile.probability.math.function.container.DomainContainers;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.requirementhelpers.BaseRequirementHelper;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A skeleton class which implements {@link BaseGrowthProfile} methods to a large extend
 *
 * @param <E> any inheritor of {@link Event}
 * @param <P> any class which inherits from this class
 *
 * @since 0.0.5
 */
abstract class AbstractBaseGrowthProfile< E extends Event, P extends AbstractBaseGrowthProfile< E, P > > implements BaseGrowthProfile< E, P > {

    @NotNull
    private BaseRequirementHelper< E > helper;

    @NotNull
    private Interval< Integer > lightLevelInterval = DomainContainers.intervalOfInclusive(15, 0, Integer::compareTo);

    @NotNull
    private Interval< Float > temperatureInterval = DomainContainers.intervalOfInclusive(Float.MAX_VALUE, Float.MIN_VALUE, Float::compareTo);

    @NotNull
    private Collection< Biome > whitelistedBiomes = new ArrayList<>();
    @NotNull
    private Collection< Biome > blacklistedBiomes = new ArrayList<>();

    /**
     * SkyAffinity depicts whether a block likes (true) being under the sun or not (false)
     */
    @Nullable
    private Boolean skyAffinity = null;


    /**
     * Default constructor
     *
     * @param helper the helper of this BaseGrowthProfile
     *
     * @since 0.0.5
     */
    AbstractBaseGrowthProfile(@Nonnull BaseRequirementHelper< E > helper) {

        this.helper = helper;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Nonnull
    @Override
    public List< GrowthCondition< E > > liquidate() {

        List< GrowthCondition< E > > ret = new ArrayList<>();

        ret.add(
                helper.intervalLightLevel(lightLevelInterval)
        );

        ret.add(
                helper.intervalTemperature(temperatureInterval)
        );

        ret.add(
                helper.whitelistBiomes(whitelistedBiomes)
        );

        ret.add(
                helper.blacklistBiomes(blacklistedBiomes)
        );

        if (skyAffinity != null) {
            ret.add(
                    skyAffinity ? helper.mustSeeSky() : helper.mustntSeeSky()
            );
        }

        return ret;
    }


    /*
            Getters
     */


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public int getMinLightLevel() {

        return lightLevelInterval.getLowerBoundValue();
    }



    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public int getMaxLightLevel() {

        return lightLevelInterval.getUpperBoundValue();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setMaxLightLevel(int maxLightLevel) {

        this.lightLevelInterval = this.lightLevelInterval.withUpperBound(DomainContainers.boundOfInclusive(maxLightLevel));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setMinLightLevel(int minLightLevel) {

        this.lightLevelInterval = this.lightLevelInterval.withLowerBound(DomainContainers.boundOfInclusive(minLightLevel));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Stream< Biome > getWhitelistedBiomes() {

        return whitelistedBiomes.stream();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Stream< Biome > getBlacklistedBiomes() {

        return blacklistedBiomes.stream();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Optional< Boolean > getSkyAffinity() {

        return Optional.ofNullable(skyAffinity);
    }


    /*
            Setters
     */


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Bound< Float > getLowerTemperatureBound() {

        return temperatureInterval.getLowerBound();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Bound< Float > getUpperTemperatureBound() {

        return temperatureInterval.getUpperBound();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public void setUpperTemperatureBound(Bound< Float > bound) {

        this.temperatureInterval = this.temperatureInterval.withUpperBound(bound);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public void setLowerTemperatureBound(Bound< Float > bound) {

        this.temperatureInterval = this.temperatureInterval.withLowerBound(bound);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setWhitelistedBiomes(@Nonnull Collection< Biome > whitelistedBiomes) {

        this.whitelistedBiomes = whitelistedBiomes;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setBlacklistedBiomes(@Nonnull Collection< Biome > blacklistedBiomes) {

        this.blacklistedBiomes = blacklistedBiomes;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setSkyAffinity(@Nullable Boolean skyAffinity) {

        this.skyAffinity = skyAffinity;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void addWhitelistedBiomes(@Nonnull Collection< Biome > biomes) {

        whitelistedBiomes.addAll(biomes);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void addBlacklistedBiomes(@Nonnull Collection< Biome > biomes) {

        whitelistedBiomes.addAll(biomes);
    }

}
