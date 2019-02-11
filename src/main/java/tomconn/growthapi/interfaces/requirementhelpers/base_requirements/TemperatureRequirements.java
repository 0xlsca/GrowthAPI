package tomconn.growthapi.interfaces.requirementhelpers.base_requirements;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Adds methods which help with creating requirements for temperatures
 *
 * @since 0.0.6
 */
public interface TemperatureRequirements< E extends Event > extends BaseRequirement< E > {

    /**
     * Returns a {@link GrowthCondition} which checks for the temperature being {@code >= min}
     *
     * @param min the minimum temperature (inclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > minTemperature(float min) {

        return temperatureMatches(f -> f >= min);
    }


    /**
     * Returns a {@link GrowthCondition} which is based on the passed {@link Predicate}
     *
     * @param temperaturePredicate the predicate that will need to be met
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > temperatureMatches(Predicate< Float > temperaturePredicate) {

        Objects.requireNonNull(temperaturePredicate);
        return tailorCondition(temperaturePredicate, e -> supplyHelper(e).getTemperature());
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the temperature being {@code > min}
     *
     * @param min the minimum temperature (exclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > minTemperatureExclusive(float min) {

        return temperatureMatches(f -> f > min);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the temperature being {@code <= min}
     *
     * @param max the maximum temperature (inclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > maxTemperature(float max) {

        return temperatureMatches(f -> f <= max);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the temperature being {@code < min}
     *
     * @param max the maximum temperature (exclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > maxTemperatureExclusive(float max) {

        return temperatureMatches(f -> f < max);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the temperature being <u>equal</u> to the passed value
     *
     * @param temp the temperature which needs to be exactly met
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > exactTemperature(float temp) {

        return temperatureMatches(f -> f == temp);
    }


    /**
     * Returns a {@link GrowthCondition} which checks whether the temperature is within the passed {@link Interval}
     *
     * @param interval the interval
     *
     * @return a new {@link GrowthCondition} which is based on the passed {@link Interval}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > intervalTemperature(Interval< Float > interval) {

        Objects.requireNonNull(interval);
        return temperatureMatches(interval::isValuePresent);
    }

}
