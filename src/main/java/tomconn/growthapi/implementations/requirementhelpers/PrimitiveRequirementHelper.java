package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.Nullable;
import tomconn.growthapi.implementations.event.helpers.PrimitiveEventHelper;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Provides functions for basic requirements
 *
 * @see PrimitiveEventHelper
 * @since 0.0.5
 */
public abstract class PrimitiveRequirementHelper< E extends Event > {

    public Predicate<E> blockMustSeeSky(){
        return this::supplyBlockCanSeeSkyFromEvent;
    }


    @Nonnull
    public Predicate<E> blockMustntSeeSky() {

        return event -> !supplyBlockCanSeeSkyFromEvent(event);
    }

    /**
     * This method supplies code which retrieves whether or not the block which triggered the event can currently see
     * the sky or not
     *
     * @return a way to call {@link World#canBlockSeeSky(BlockPos)}
     * @since 0.0.5
     */
    protected abstract boolean supplyBlockCanSeeSkyFromEvent(E event);

    /**
     * Returns a predicate which checks the from the event retrieved temperature against the provided temperature-
     * matcher and returns a respective boolean value
     *
     * @param temperatureMatcher  the boolean logic which decides whether or not the passed temperature is desired (true)
     *                            or not (false)
     * @return a respective predicate based on the provided matcher and supplier
     * @since 0.0.5
     */
    @Nonnull
    public Predicate< E > temperatureMatches(@Nullable Predicate< Float > temperatureMatcher) {
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
     * @since 0.0.5
     */
    protected abstract float supplyBiomeBasedTemperatureFromEvent(E event);

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is one of the provided ones
     *
     * @param whitelistedBiomes the {@link Biome}s which are desired
     * @return a predicate which returns true ii the block is located in any of the provided {@link Biome}s
     * @since 0.0.5
     */
    @Nonnull
    public Predicate< E > blockHasBiomes(@Nullable Collection< Biome > whitelistedBiomes) {
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
     * @since 0.0.5
     */
    @Nonnull
    public Predicate<E> blockHasBiome(Biome... biomes) {
        return blockHasBiomes(Arrays.asList(biomes));
    }

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is not one of the provided ones.
     *
     * @param blacklistedBiomes the {@link Biome}s which the block shall not have
     * @return a predicate which returns true if the block is not located within any of the provided {@link Biome}s
     * @since 0.0.5
     */
    @Nonnull
    public Predicate< E > blockDoesNotHaveBiome(@Nullable Biome... blacklistedBiomes) {
        //we simply negate whether the block is in one of the blacklisted biomes
        return event -> {

            if (blacklistedBiomes != null) {
                return !blockHasBiome(blacklistedBiomes).test(event);
            }

            return true;
        };
    }


    @Nonnull
    public Predicate< E > blockDoesNotHaveBiomes(@Nullable Collection< Biome > blacklistedBiomes) {
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
     * @since 0.0.5
     */
    @Nonnull
    protected abstract Biome supplyBiomeFromEvent(E event);

    /**
     * Returns a predicate which checks whether the block's light-level is sufficient for the block to pass in a
     * {@link BlockEvent.CropGrowEvent.Pre} event
     *
     * @param lightLevelMatcher boolean logic which decides whether or not the passed light-level is sufficient
     * @return a respective predicate based on the provided matcher
     *
     * @since 0.0.5
     */
    @Nonnull
    public Predicate< E > lightlevelMatches(@Nullable Predicate< Integer > lightLevelMatcher) {
        return event -> {

            if (lightLevelMatcher != null) {
                return lightLevelMatcher.test(supplyLightLevelFromEvent(event));
            }

            return true;
        };
    }

    /**
     * This method supplies code which retrieves the light-level of the block from the {@link World}
     * the block is located in via {@link World#getLight(BlockPos)}
     *
     * @return the light-level of the block
     *
     * @since 0.0.5
     */
    protected abstract int supplyLightLevelFromEvent(E event);
}
