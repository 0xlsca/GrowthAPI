package tomconn.growthapi.interfaces.growthprofile.base;

import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

/**
 * Adds methods for setting and retrieving the minimum needed and maximum allowed temperature
 *
 * @param <P> the implementing class
 *
 * @since 0.0.6
 */
public interface TemperatureMethods< P extends GrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * Returns the currently set minimum-required temperature
     *
     * @return the minimum required temperature
     *
     * @since 0.0.6
     */
    float getMinTemperature();


    /**
     * Returns the currently set maximum-required temperature
     *
     * @return the maximum required temperature
     *
     * @since 0.0.6
     */
    float getMaxTemperature();


    /**
     * A chaining-wrapper for {@link #setMinTemperature(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMinTemperature(float)
     * @since 0.0.6
     */
    default P minTemp(float min) {

        setMinTemperature(min);
        return getThis();
    }


    /**
     * A chaining-wrapper for {@link #setMaxTemperature(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMaxTemperature(float)
     * @since 0.0.6
     */
    default P maxTemp(float max) {

        setMaxTemperature(max);
        return getThis();
    }


    /**
     * Sets the minimum required temperature a block needs in order to grow.
     *
     * @param min the temperature
     *
     * @since 0.0.6
     */
    void setMinTemperature(float min);


    /**
     * Sets the maximum required temperature a block needs in order to grow
     *
     * @param max the temperature
     *
     * @since 0.0.6
     */
    void setMaxTemperature(float max);

}
