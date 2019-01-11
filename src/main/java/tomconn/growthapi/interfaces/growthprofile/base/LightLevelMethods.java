package tomconn.growthapi.interfaces.growthprofile.base;

import tomconn.growthapi.interfaces.growthprofile.BaseGrowthProfile;

/**
 * This interface unifies methods for getting, setting and chaining the minimum or maximum light-level
 *
 * @param <P> the {@link BaseGrowthProfile} which implements this interface
 *
 * @since 0.0.6
 */
public interface LightLevelMethods< P extends BaseGrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * Returns the currently set minimum light-level
     *
     * @return the minimum light-level
     *
     * @since 0.0.6
     */
    int getMinLightLevel();


    /**
     * Returns the currently set maximum light-level
     *
     * @return the maximum light-level
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
     * @return <ul>
     * <li>true  - if and only if the currently set value has been exchanged with the passed one</li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    void setMinLightLevel(int min);


    /**
     * Sets the maximum light-level to the passed value
     *
     * @return <ul>
     * <li>true  - if and only if the currently set value has been exchanged with the passed one</li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    void setMaxLightLevel(int max);


    /**
     * Sets both the min and max light-level to the passed int.
     *
     * @param exact the exact light-level
     *
     * @return this object for chaning purposes
     */
    default P exactLight(int exact) {

        return minLight(exact).maxLight(exact);
    }

}
