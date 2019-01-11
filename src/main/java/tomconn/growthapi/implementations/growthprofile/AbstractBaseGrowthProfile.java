package tomconn.growthapi.implementations.growthprofile;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.Nullable;
import tomconn.growthapi.implementations.requirementhelpers.PrimitiveRequirementHelper;
import tomconn.growthapi.interfaces.growthprofile.BaseGrowthProfile;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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

    protected PrimitiveRequirementHelper< E > helper;

    protected int minLightLevel = Integer.MIN_VALUE;
    protected int maxLightLevel = Integer.MAX_VALUE;

    protected float minTemperature = Float.MIN_VALUE;
    protected float maxTemperature = Float.MAX_VALUE;

    protected Collection< Biome > whitelistedBiomes = new ArrayList<>();
    protected Collection< Biome > blacklistedBiomes = new ArrayList<>();

    /**
     * SkyAffinity depicts whether a block likes (true) being under the sun or not (false)
     */
    @Nullable
    protected Boolean skyAffinity = null;


    /**
     * Default constructor
     *
     * @param helper the helper of this BaseGrowthProfile
     *
     * @since 0.0.5
     */
    public AbstractBaseGrowthProfile(PrimitiveRequirementHelper< E > helper) {

        this.helper = helper;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Nonnull
    @Override
    public List< Predicate< E > > liquidate() {

        List< Predicate< E > > ret = new ArrayList<>();

        ret.add(
                helper.lightlevelMatches(
                        lightLevel -> lightLevel <= maxLightLevel && lightLevel >= minLightLevel
                )
        );

        ret.add(
                helper.temperatureMatches(
                        temperature -> temperature <= maxTemperature && temperature >= minTemperature
                )
        );

        ret.add(
                helper.blockHasBiomes(whitelistedBiomes)
        );

        ret.add(
                helper.blockDoesNotHaveBiomes(blacklistedBiomes)
        );

        if (skyAffinity != null) {
            ret.add(
                    skyAffinity ? helper.blockMustSeeSky() : helper.blockMustntSeeSky()
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
     * @since 0.0.5
     */
    @Override
    public int getMinLightLevel() {

        return minLightLevel;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public int getMaxLightLevel() {

        return maxLightLevel;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public float getMinTemperature() {

        return minTemperature;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public float getMaxTemperature() {

        return maxTemperature;
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
    public void setMinLightLevel(int minLightLevel) {

        this.minLightLevel = minLightLevel;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setMaxLightLevel(int maxLightLevel) {

        this.maxLightLevel = maxLightLevel;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setMinTemperature(float minTemperature) {

        this.minTemperature = minTemperature;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setMaxTemperature(float maxTemperature) {

        this.maxTemperature = maxTemperature;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setWhitelistedBiomes(Collection< Biome > whitelistedBiomes) {

        this.whitelistedBiomes = whitelistedBiomes;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public void setBlacklistedBiomes(Collection< Biome > blacklistedBiomes) {

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
