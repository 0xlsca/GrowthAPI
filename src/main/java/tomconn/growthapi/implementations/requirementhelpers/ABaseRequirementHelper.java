package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Provides functions for basic requirements
 *
 * @see tomconn.growthapi.implementations.eventhelpers.ABaseEventHelper
 */
public abstract class ABaseRequirementHelper {

    /**
     * Returns a predicate which checks whether the block can see the sky
     *
     * @return a respective predicate
     */
    public <E extends Event> Predicate<E>
    blockCanSeeSky(Function<E, Boolean> canSee, boolean ifCanSee, boolean ifCannotSee) {
        return event -> {
            if (canSee.apply(event)) {
                return ifCanSee;
            } else {
                return ifCannotSee;
            }
        };
    }

    /**
     * Returns a predicate which checks the from the event retrieved temperature against the provided temperature-
     * matcher and returns a respective boolean value
     *
     * @param temperatureMatcher the boolean logic which decides whether or not the passed temperature is desired (true)
     *                           or not (false)
     * @param temperatureSupplier a function which takes the event and returns a float which depicts the block's current
     *                            temperature
     * @return a respective predicate based on the provided matcher and supplier
     */
    public <E extends Event> Predicate<E>
    temperatureMatches(Function<E, Float> temperatureSupplier, Predicate<Float> temperatureMatcher) {
        return event -> {

            if (temperatureMatcher != null) {
                return temperatureMatcher.test(temperatureSupplier.apply(event));
            }

            return true;
        };
    }

    /**
     * Returns a predicate which checks whether the block's {@link Biome} is one of the provided ones
     *
     * @param biomeSupplier a function which returns the block's biome, based on the event
     * @param whitelistedBiomes the {@link Biome}s which are desired
     * @return a predicate which returns true ii the block is located in any of the provided {@link Biome}s
     */
    public <E extends Event> Predicate<E>
    blockHasBiomes(Function<E, Biome> biomeSupplier, List<Biome> whitelistedBiomes) {
        return event -> {

            if (whitelistedBiomes != null) {
                return whitelistedBiomes.stream()
                        .anyMatch(biome -> biomeSupplier.apply(event) == biome);
            }

            return true;
        };
    }
}
