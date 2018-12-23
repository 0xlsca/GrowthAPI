package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.eventhelpers.CropGrowPreEventHelper;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * This class provides utility for the creation of growth requirements of crops.
 */
public class CropGrowPreRequirementHelper {


    /**
     * Returns a predicate which checks whether the block can see the sky
     *
     * @return a respective predicate
     */
    public static Predicate<Pre> blockCanSeeSky(boolean ifCanSee, boolean ifCannotSee) {
        return event -> {
            if (new CropGrowPreEventHelper(event).canSeeSky()) {
                return ifCanSee;
            } else {
                return ifCannotSee;
            }
        };
    }


    /**
     * Returns a predicate which checks the block's current temperature against the provided temperature-matcher
     * and returns a respective boolean value
     *
     * @param temperatureMatcher the boolean logic which decides whether or not the passed temperature is desired (true)
     *                           or not (false)
     * @return a respective predicate based on the provided matcher
     */
    public static Predicate<Pre> temperatureMatches(Predicate<Float> temperatureMatcher) {
        return event -> {

            if (temperatureMatcher != null) {
                return temperatureMatcher.test(new CropGrowPreEventHelper(event).getBlockTemperature());
            }

            return true;
        };
    }


    /**
     * Returns a predicate which checks whether the block's {@link Biome} is one of the provided ones
     *
     * @param biomes the {@link Biome}s which are desired
     * @return a predicate which returns true ii the block is located in any of the provided {@link Biome}s
     */
    public static Predicate<Pre> blockHasBiome(Biome... biomes) {
        return blockHasBiomes(Arrays.asList(biomes));
    }

    /**
     * A {@link List}-based wrapper for {@link #blockHasBiome(Biome...)}
     *
     * @param whitelistedBiomes a {@link List} of whitelisted biomes
     */
    public static Predicate<Pre> blockHasBiomes(List<Biome> whitelistedBiomes) {
        return event -> {

            if (whitelistedBiomes != null) {
                CropGrowPreEventHelper helper
                        = new CropGrowPreEventHelper(event); //this prevents constant new-instantiation in the lambda
                return whitelistedBiomes.stream()
                        .anyMatch(biome -> helper.getBiome() == biome);//this could cause performance issues
                // if the biome-querying isn't fast
            }

            return true;
        };
    }

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is not one of the provided ones.
     *
     * @param blacklistedBiomes the {@link Biome}s which the block shall not have
     * @return a predicate which returns true if the block is not located within any of the provided {@link Biome}s
     */
    public static Predicate<Pre> blockDoesNotHaveBiome(Biome... blacklistedBiomes) {
        //we simply negate whether the block is in one of the blacklisted biomes
        return event -> {

            if (blacklistedBiomes != null) {
                return !blockHasBiome(blacklistedBiomes).test(event);
            }

            return true;
        };
    }

    public static Predicate<Pre> blockDoesNotHaveBiomes(List<Biome> blacklistedBiomes) {
        return event -> {

            if (blacklistedBiomes != null) {
                return !blockHasBiomes(blacklistedBiomes).test(event);
            }

            return true;
        };
    }

    /**
     * Returns a predicate which checks whether the block's light-level is sufficient for the block to pass in a
     * {@link Pre} event
     *
     * @param lightLevelMatcher boolean logic which decides whether or not the passed light-level is sufficient
     * @return a respective predicate based on the provided matcher
     */
    public static Predicate<Pre> lightlevelMatches(Predicate<Integer> lightLevelMatcher) {
        return event -> {

            if (lightLevelMatcher != null) {
                return lightLevelMatcher.test(new CropGrowPreEventHelper(event).getLightLevel());
            }

            return true;
        };
    }

}