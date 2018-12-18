package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.eventhelpers.CropGrowPreEventHelper;

import java.util.Arrays;
import java.util.function.Predicate;


/**
 * This class provides utility for the creation of growth requirements of crops.
 * <p>
 * This class is a singleton.
 */
public class CropGrowPreRequirementHelper {

    /*
    Singleton stuff
    */
    private static CropGrowPreRequirementHelper instance = new CropGrowPreRequirementHelper();

    private CropGrowPreRequirementHelper() {
    }

    public static CropGrowPreRequirementHelper getInstance() {
        return instance;
    }


    /*
    Attributes go here
     */


    /*
    Methods go here
     */


    /**
     * Returns a predicate which checks whether the block can see the sky
     *
     * @return a respective predicate
     */
    public Predicate<Pre> blockCanSeeSky(boolean ifCanSee) {
        return event -> {
            if (new CropGrowPreEventHelper(event).canSeeSky()) {
                return ifCanSee;
            } else {
                return !ifCanSee;
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
    public Predicate<Pre> temperatureMatches(Predicate<Float> temperatureMatcher) {
        return event -> temperatureMatcher.test(new CropGrowPreEventHelper(event).getBlockTemperature());
    }


    /**
     * Returns a predicate which checks whether the block's {@link Biome} is one of the provided ones
     *
     * @param biomes the {@link Biome}s which are desired
     * @return a predicate which returns true ii the block is located in any of the provided {@link Biome}s
     */
    public Predicate<Pre> blockHasBiome(Biome... biomes) {
        return event -> {
            CropGrowPreEventHelper helper
                    = new CropGrowPreEventHelper(event);      //this prevents constant new-instantiation
            return Arrays.stream(biomes)
                    .anyMatch(b -> helper.getBiome() == b);    //this could cause performance issues
            // if the biome-querying isn't fast
        };
    }

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is not one of the provided ones.
     *
     * @param biomes the {@link Biome}s which the block shall not have
     * @return a predicate which returns true if the block is not located within any of the provided {@link Biome}s
     */
    public Predicate<Pre> blockDoesNotHaveBiome(Biome... biomes) {
        return event -> !blockHasBiome(biomes).test(event); //we simply negate whether the block is in one of the biomes
    }

    /**
     * Returns a predicate which checks whether the block's light-level is sufficient for the block to pass in a
     * {@link Pre} event
     *
     * @param lightLevelMatcher boolean logic which decides whether or not the passed light-level is sufficient
     * @return a respective predicate based on the provided matcher
     */
    public Predicate<Pre> lightlevelMatches(Predicate<Integer> lightLevelMatcher) {
        return event -> lightLevelMatcher.test(new CropGrowPreEventHelper(event).getLightLevel());
    }

}