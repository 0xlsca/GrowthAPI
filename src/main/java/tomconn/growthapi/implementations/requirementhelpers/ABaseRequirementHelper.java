package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Provides functions for basic requirements
 *
 * @see tomconn.growthapi.implementations.eventhelpers.ABaseEventHelper
 */
public abstract class ABaseRequirementHelper<E extends Event> {

    /**
     * Returns a predicate which checks whether the block can see the sky
     *
     * @return a respective predicate
     */
    public Predicate<E> blockCanSeeSky(boolean ifCanSee, boolean ifCannotSee) {
        return event -> {
            if (supplyBlockCanSeeSkyFromEvent(event)) {
                return ifCanSee;
            } else {
                return ifCannotSee;
            }
        };
    }

    /**
     * This method supplies code which retrieves whether or not the block which triggered the event can currently see
     * the sky or not
     *
     * @return a way to call {@link net.minecraft.world.World#canBlockSeeSky(BlockPos)}
     */
    protected abstract boolean supplyBlockCanSeeSkyFromEvent(E event);

    /**
     * Returns a predicate which checks the from the event retrieved temperature against the provided temperature-
     * matcher and returns a respective boolean value
     *
     * @param temperatureMatcher  the boolean logic which decides whether or not the passed temperature is desired (true)
     *                            or not (false)
     * @return a respective predicate based on the provided matcher and supplier
     */
    public Predicate<E> temperatureMatches(Predicate<Float> temperatureMatcher) {
        return event -> {

            if (temperatureMatcher != null) {
                return temperatureMatcher.test(supplyBiomeBasedTemperatureFromEvent(event));
            }

            return true;
        };
    }

    /**
     * This method supplies code which retrieves the {@link Biome}-based temperature of the block
     *
     * @return a way to call {@link Biome#getTemperature(BlockPos)}
     */
    protected abstract float supplyBiomeBasedTemperatureFromEvent(E event);

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is one of the provided ones
     *
     * @param whitelistedBiomes the {@link Biome}s which are desired
     * @return a predicate which returns true ii the block is located in any of the provided {@link Biome}s
     */
    public Predicate<E> blockHasBiomes(List<Biome> whitelistedBiomes) {
        return event -> {

            if (whitelistedBiomes != null) {
                Biome blockBiome = supplyBiomeFromEvent(event);
                return whitelistedBiomes.stream()
                        .anyMatch(biome -> blockBiome == biome);
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
    public Predicate<E> blockHasBiome(Biome... biomes) {
        return blockHasBiomes(Arrays.asList(biomes));
    }

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is not one of the provided ones.
     *
     * @param blacklistedBiomes the {@link Biome}s which the block shall not have
     * @return a predicate which returns true if the block is not located within any of the provided {@link Biome}s
     */
    public Predicate<E> blockDoesNotHaveBiome(Biome... blacklistedBiomes) {
        //we simply negate whether the block is in one of the blacklisted biomes
        return event -> {

            if (blacklistedBiomes != null) {
                return !blockHasBiome(blacklistedBiomes).test(event);
            }

            return true;
        };
    }

    public Predicate<E> blockDoesNotHaveBiomes(List<Biome> blacklistedBiomes) {
        return event -> {

            if (blacklistedBiomes != null) {
                return !blockHasBiomes(blacklistedBiomes).test(event);
            }

            return true;
        };
    }

    /**
     * This method supplies code which retrieves the {@link Biome} in which the block is located
     *
     * @return The {@link Biome} of the block
     */
    protected abstract Biome supplyBiomeFromEvent(E event);

    /**
     * Returns a predicate which checks whether the block's light-level is sufficient for the block to pass in a
     * {@link BlockEvent.CropGrowEvent.Pre} event
     *
     * @param lightLevelMatcher boolean logic which decides whether or not the passed light-level is sufficient
     * @return a respective predicate based on the provided matcher
     */
    public Predicate<E> lightlevelMatches(Predicate<Integer> lightLevelMatcher) {
        return event -> {

            if (lightLevelMatcher != null) {
                return lightLevelMatcher.test(supplyLightLevelFromEvent(event));
            }

            return true;
        };
    }

    /**
     * This method supplies code which retrieves the light-level of the block from the {@link net.minecraft.world.World}
     * the block is located in via {@link net.minecraft.world.World#getLight(BlockPos)}
     *
     * @return the light-level of the block
     */
    protected abstract int supplyLightLevelFromEvent(E event);
}
