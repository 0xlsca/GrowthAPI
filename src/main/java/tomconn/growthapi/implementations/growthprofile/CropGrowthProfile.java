package tomconn.growthapi.implementations.growthprofile;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.interfaces.growthprofile.IGrowthProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static tomconn.growthapi.implementations.requirementhelpers.CropGrowPreRequirementHelper.*;

/**
 * This profile covers all growth related things for crops.
 * It was designed with the option to be extendable.
 * <p>
 * This class incorporates chaining methods, which allow for eased building of distinct profiles.
 */
public class CropGrowthProfile implements IGrowthProfile<BlockEvent.CropGrowEvent.Pre> {

    protected int minLightLevel = Integer.MIN_VALUE;
    protected int maxLightLevel = Integer.MAX_VALUE;

    protected float minTemperature = Float.MIN_VALUE;
    protected float maxTemperature = Float.MAX_VALUE;

    protected List<Biome> whitelistedBiomes = null;
    protected List<Biome> blacklistedBiomes = null;

    protected boolean dontCareAboutSky = true;      //this flag signals that the view to sky is not cared about
    protected boolean mustSeeSky = true;
    protected boolean mustntSeeSky = false;


    @Override
    public List<Predicate<BlockEvent.CropGrowEvent.Pre>> liquidate() {
        List<Predicate<BlockEvent.CropGrowEvent.Pre>> ret = new ArrayList<>();

        ret.add(
                lightlevelMatches(
                        lightLevel -> lightLevel <= maxLightLevel && lightLevel >= minLightLevel
                )
        );

        ret.add(
                temperatureMatches(
                        temperature -> temperature <= maxTemperature && temperature >= minTemperature
                )
        );

        ret.add(
                blockHasBiomes(whitelistedBiomes)
        );

        ret.add(
                blockDoesNotHaveBiomes(blacklistedBiomes)
        );

        ret.add(
                dontCareAboutSky ?

                        blockCanSeeSky(true, true)
                        :
                        blockCanSeeSky(
                                mustSeeSky && !mustntSeeSky,            //if both values are set, neither
                                !(mustSeeSky && !mustntSeeSky)       //can be met
                        )
        );

        return ret;
    }

   /*
            Chaining methods
    */

    public CropGrowthProfile minLight(int min) {
        setMinLightLevel(min);
        return this;
    }

    public CropGrowthProfile maxLight(int max) {
        setMaxLightLevel(max);
        return this;
    }

    public CropGrowthProfile whitelistBiome(Biome... biomes) {
        whitelistedBiomes.addAll(Arrays.asList(biomes));
        return this;
    }

    public CropGrowthProfile whitelistBiomes(List<Biome> biomes) {
        whitelistedBiomes.addAll(biomes);
        return this;
    }

    public CropGrowthProfile blacklistBiome(Biome... biomes) {
        blacklistedBiomes.addAll(Arrays.asList(biomes));
        return this;
    }

    public CropGrowthProfile blacklistBiomes(List<Biome> biomes) {
        blacklistedBiomes.addAll(biomes);
        return this;
    }

    public CropGrowthProfile needsSky(boolean needsToSeeSky) {
        this.mustSeeSky = needsToSeeSky;
        return this;
    }

    /**
     * Sets both the min and max light-level to the passed int.
     *
     * @param exact the exact light-level
     * @return this object for chaning purposes
     */
    public CropGrowthProfile exactLight(int exact) {
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

    public boolean isMustSeeSky() {
        return mustSeeSky;
    }

    public boolean isMustntSeeSky() {
        return mustntSeeSky;
    }

    /**
     * Returns whether or not this profile cares about whether the block has a clear line mof sight to the sky
     */
    public boolean isDontCareAboutSky() {
        return dontCareAboutSky;
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

    public void setMustSeeSky(boolean mustSeeSky) {
        this.dontCareAboutSky = false;
        this.mustSeeSky = mustSeeSky;
    }

    public void setMustntSeeSky(boolean mustntSeeSky) {
        this.dontCareAboutSky = false;
        this.mustntSeeSky = mustntSeeSky;
    }

}
