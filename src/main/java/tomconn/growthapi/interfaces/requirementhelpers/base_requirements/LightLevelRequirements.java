package tomconn.growthapi.interfaces.requirementhelpers.base_requirements;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Adds methods which help with creating requirements for light-levels
 *
 * @since 0.0.6
 */
public interface LightLevelRequirements< E extends Event > extends BaseRequirement< E > {

    /**
     * Returns a {@link GrowthCondition} which checks for the light-level being {@code >= min}
     *
     * @param min the minimum the light-level (inclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > minLightLevel(int min) {

        return lightLevelMatches(ll -> ll >= min);
    }


    /**
     * Returns a {@link GrowthCondition} which is based on the passed {@link Predicate}
     *
     * @param lightLevelPredicate the predicate that will need to be met
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > lightLevelMatches(Predicate< Integer > lightLevelPredicate) {

        Objects.requireNonNull(lightLevelPredicate);
        return tailorCondition(lightLevelPredicate, event -> supplyHelper(event).getLightLevel());
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the the light-level being {@code > min}
     *
     * @param min the minimum the light-level (exclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > minLightLevelExclusive(int min) {

        return lightLevelMatches(ll -> ll > min);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the the light-level being {@code <= min}
     *
     * @param max the maximum the light-level (inclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > maxLightLevel(int max) {

        return lightLevelMatches(ll -> ll <= max);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the the light-level being {@code < min}
     *
     * @param max the maximum the light-level (exclusive)
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > maxLightLevelExclusive(int max) {

        return lightLevelMatches(ll -> ll < max);
    }


    /**
     * Returns a {@link GrowthCondition} which checks for the the light-level being <u>equal</u> to the passed value
     *
     * @param lightLevel the the light-level which needs to be exactly met
     *
     * @return a new {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > exactLightLevel(int lightLevel) {

        return lightLevelMatches(ll -> ll == lightLevel);
    }


    /**
     * Returns a {@link GrowthCondition} which checks whether the light-level is within the passed {@link Interval}
     *
     * @param interval the interval
     *
     * @return a new {@link GrowthCondition} which is based on the passed {@link Interval}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > intervalLightLevel(Interval< Integer > interval) {

        Objects.requireNonNull(interval);
        return lightLevelMatches(interval::isValuePresent);
    }

}
