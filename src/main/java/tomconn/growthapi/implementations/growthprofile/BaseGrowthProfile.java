package tomconn.growthapi.implementations.growthprofile;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.requirementhelpers.PrimitiveRequirementHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Defines shared attributes among crop- and sapling growth-profiles
 */
public abstract class BaseGrowthProfile< E extends Event > implements tomconn.growthapi.interfaces.growthprofile.GrowthProfile {

    protected PrimitiveRequirementHelper< E > helper;

    protected int minLightLevel = Integer.MIN_VALUE;
    protected int maxLightLevel = Integer.MAX_VALUE;

    protected float minTemperature = Float.MIN_VALUE;
    protected float maxTemperature = Float.MAX_VALUE;

    protected List<Biome> whitelistedBiomes = null;
    protected List<Biome> blacklistedBiomes = null;

    /**
     * SkyAffinity depicts whether a block likes (true) being under the sun or not (false)
     */
    protected Boolean skyAffinity = null;


    public BaseGrowthProfile(PrimitiveRequirementHelper< E > helper) {
        this.helper = helper;
    }

    @Override
    public List<Predicate<E>> liquidate() {
        List<Predicate<E>> ret = new ArrayList<>();

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
            Chaining methods
    */


    public BaseGrowthProfile< E > minLight(int min) {
        setMinLightLevel(min);
        return this;
    }


    public BaseGrowthProfile< E > maxLight(int max) {
        setMaxLightLevel(max);
        return this;
    }


    public BaseGrowthProfile< E > whitelistBiome(Biome... biomes) {
        whitelistedBiomes.addAll(Arrays.asList(biomes));
        return this;
    }


    public BaseGrowthProfile< E > whitelistBiomes(List< Biome > biomes) {
        whitelistedBiomes.addAll(biomes);
        return this;
    }


    public BaseGrowthProfile< E > blacklistBiome(Biome... biomes) {
        blacklistedBiomes.addAll(Arrays.asList(biomes));
        return this;
    }


    public BaseGrowthProfile< E > blacklistBiomes(List< Biome > biomes) {
        blacklistedBiomes.addAll(biomes);
        return this;
    }


    public BaseGrowthProfile< E > skyAffinity(Boolean skyAffinity) {
        setSkyAffinity(skyAffinity);
        return this;
    }

    /**
     * Sets both the min and max light-level to the passed int.
     *
     * @param exact the exact light-level
     * @return this object for chaning purposes
     */
    public BaseGrowthProfile< E > exactLight(int exact) {
        return minLight(exact).maxLight(exact);
    }


    /*
            Getters
     */


    public int getMinLightLevel() {
        return minLightLevel;
    }

    public int getMaxLightLevel() {
        return maxLightLevel;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public List<Biome> getWhitelistedBiomes() {
        return whitelistedBiomes;
    }

    public List<Biome> getBlacklistedBiomes() {
        return blacklistedBiomes;
    }

    public boolean getSkyAffinity() {
        return skyAffinity;
    }

    /*
            Setters
     */


    public void setMinLightLevel(int minLightLevel) {
        this.minLightLevel = minLightLevel;
    }

    public void setMaxLightLevel(int maxLightLevel) {
        this.maxLightLevel = maxLightLevel;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setWhitelistedBiomes(List<Biome> whitelistedBiomes) {
        this.whitelistedBiomes = whitelistedBiomes;
    }

    public void setBlacklistedBiomes(List<Biome> blacklistedBiomes) {
        this.blacklistedBiomes = blacklistedBiomes;
    }

    /**
     * Sky affinity depicts whether this block likes (true) or dislikes (false) being under the sun
     * @param skyAffinity true in case this block must, false in case this block mustn't be under the sky.<br>null to
     *                    flag a "don't care" behavior
     */
    public void setSkyAffinity(Boolean skyAffinity) {
        this.skyAffinity = skyAffinity;
    }

}
