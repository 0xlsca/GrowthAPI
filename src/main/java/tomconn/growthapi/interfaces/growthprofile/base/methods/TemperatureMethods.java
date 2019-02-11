package tomconn.growthapi.interfaces.growthprofile.base.methods;

import tomconn.growthapi.implementations.growthprofile.probability.math.function.container.DomainContainers;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound.BoundKind;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

/**
 * <p>Adds methods for setting and retrieving the minimum needed and maximum allowed temperature.</p>
 * <p>Implementors are required to use a backing {@link Interval} for the minimum- and maximum values.</p>
 *
 * @param <P> the implementing class
 *
 * @since 0.0.6
 */
public interface TemperatureMethods< P extends BaseGrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * Returns the currently set minimum-required temperature
     *
     * @return the minimum required temperature
     *
     * @since 0.0.6
     */
    Bound< Float > getLowerTemperatureBound();


    /**
     * Sets the lower bound of the backing {@link Interval}
     *
     * @param bound the bound
     *
     * @since 0.0.6
     */
    void setLowerTemperatureBound(Bound< Float > bound);


    /**
     * Returns the currently set maximum-required temperature
     *
     * @return the maximum required temperature
     *
     * @since 0.0.6
     */
    Bound< Float > getUpperTemperatureBound();


    /**
     * Sets the upper bound of the backing {@link Interval}
     *
     * @param bound the bound
     *
     * @since 0.0.6
     */
    void setUpperTemperatureBound(Bound< Float > bound);


    /**
     * A chaining-wrapper for {@link #setMinTemperatureInclusive(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMinTemperatureInclusive(float)
     * @since 0.0.6
     */
    default P minTempIn(float min) {

        setMinTemperatureInclusive(min);
        return getThis();
    }


    /**
     * A {@link BoundKind#INCLUSIVE} based chaining-wrapper for {@link #setLowerTemperatureBound(Bound)}
     *
     * @param min the temperature
     *
     * @since 0.0.6
     */
    default void setMinTemperatureInclusive(float min) {

        setLowerTemperatureBound(DomainContainers.boundOfInclusive(min));
    }


    /**
     * A chaining-wrapper for {@link #setMinTemperatureInclusive(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMinTemperatureInclusive(float)
     * @since 0.0.6
     */
    default P minTempEx(float min) {

        setMinTemperatureInclusive(min);
        return getThis();
    }


    /**
     * A chaining-wrapper for {@link #setMaxTemperatureInclusive(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMaxTemperatureInclusive(float)
     * @since 0.0.6
     */
    default P maxTempIn(float max) {

        setMaxTemperatureInclusive(max);
        return getThis();
    }


    /**
     * A {@link BoundKind#INCLUSIVE} based chaining-wrapper for {@link #setUpperTemperatureBound(Bound)}
     *
     * @param max the temperature
     *
     * @since 0.0.6
     */
    default void setMaxTemperatureInclusive(float max) {

        setUpperTemperatureBound(DomainContainers.boundOfInclusive(max));
    }


    /**
     * A chaining-wrapper for {@link #setMaxTemperatureExclusive(float)}
     *
     * @return this instance, for chaining purposes
     *
     * @see #setMaxTemperatureExclusive(float)
     * @since 0.0.6
     */
    default P maxTempEx(float max) {

        setMaxTemperatureInclusive(max);
        return getThis();
    }


    /**
     * A {@link BoundKind#EXCLUSIVE} based chaining-wrapper for {@link #setLowerTemperatureBound(Bound)}
     *
     * @param min the temperature
     *
     * @since 0.0.6
     */
    default void setMinTemperatureExclusive(float min) {

        setLowerTemperatureBound(DomainContainers.boundOfExclusive(min));
    }


    /**
     * A {@link BoundKind#EXCLUSIVE} based chaining-wrapper for {@link #setUpperTemperatureBound(Bound)}
     *
     * @param max the temperature
     *
     * @since 0.0.6
     */
    default void setMaxTemperatureExclusive(float max) {

        setUpperTemperatureBound(DomainContainers.boundOfExclusive(max));
    }

}
