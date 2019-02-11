package tomconn.growthapi.interfaces.growthprofile.base.methods;

import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

/**
 * <p>This interface unifies methods for getting, setting and chaining the minimum or maximum light-level.</p>
 * <p>All passed value are to be understood as inclusive, meaning that, for instance, an encountered light-level of
 * {@code 15} would sill suffice if the maximum light-level was set to {@code 15}</p>
 * <p>Implementors are encouraged, but not required to make use of a backing {@link Interval}.</p>
 *
 * @param <P> the {@link BaseGrowthProfile} which implements this interface
 *
 * @since 0.0.6
 */
public interface LightLevelMethods< P extends BaseGrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * <p>Returns the currently set minimum light-level.</p>
     * <p>The value is considered to be inclusive and will return in a positive-decision if an encountered value equals it.</p>
     *
     * @return the minimum, inclusive light-level
     *
     * @since 0.0.6
     */
    int getMinLightLevel();


    /**
     * <p>Returns the currently set maximum light-level.</p>
     * <p>The value is considered to be inclusive and will return in a positive-decision if an encountered value equals it.</p>
     *
     * @return the maximum, inclusive light-level
     *
     * @since 0.0.6
     */
    int getMaxLightLevel();


    /**
     * A chaining-method which sets the minimum light-level and returns this instance so followup calls to other methods
     * of this instance can be made
     *
     * @return this profile
     *
     * @since 0.0.6
     */
    default P minLight(int min) {

        setMinLightLevel(min);
        return getThis();
    }


    /**
     * A chaining-method which sets the maximum light-level and returns this instance so followup calls to other methods
     * of this instance can be made
     *
     * @return this profile
     *
     * @since 0.0.6
     */
    default P maxLight(int max) {

        setMaxLightLevel(max);
        return getThis();
    }


    /**
     * Sets the minimum light-level to the passed value
     *
     * @since 0.0.6
     */
    void setMinLightLevel(int min);


    /**
     * Sets the maximum light-level to the passed value
     *
     * @since 0.0.6
     */
    void setMaxLightLevel(int max);


    /**
     * Sets both the min and max light-level to the passed int.
     *
     * @param exact the exact light-level
     *
     * @return this object for chaining purposes
     */
    default P exactLight(int exact) {

        return minLight(exact).maxLight(exact);
    }

}
