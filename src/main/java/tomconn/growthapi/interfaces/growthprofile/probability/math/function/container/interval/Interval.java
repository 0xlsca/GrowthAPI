package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound.BoundKind;

import javax.annotation.Nonnull;
import java.util.Comparator;

/**
 * This interface denotes methods which are required to represent an interval, mathematically speaking
 *
 * @since 0.0.6
 */
public interface Interval< T > extends DomainContainer< T > {


    /**
     * Returns a new instance with the specified upper bound
     *
     * @param upper the new upper bound
     *
     * @return a new instance with the passed upper bound
     *
     * @since 0.0.6
     */
    Interval< T > withUpperBound(Bound< T > upper);


    /**
     * Returns a copy of this Interval with the set upper value.
     *
     * @param value the value to set for the upper bound
     *
     * @return a copy of this instance with the set upper value
     *
     * @since 0.0.6
     */
    Interval< T > withUpperValue(T value);


    /**
     * Returns a copy of this Interval with the set lower value.
     *
     * @param value the value to set for the lower bound
     *
     * @return a copy of this instance with the set lower value
     *
     * @since 0.0.6
     */
    Interval< T > withLowerValue(T value);


    /**
     * Returns a new instance with the specified lower bound
     *
     * @param lower the new lower bound
     *
     * @return a new instance with the passed lower bound
     *
     * @since 0.0.6
     */
    Interval< T > withLowerBound(Bound< T > lower);


    /**
     * A default method to check whether a provided value matches the upper bound, based on a passed {@link Comparator}
     *
     * @param value      the value
     * @param comparator the comparator, which is specialized for the underlying type of this interval
     *
     * @return <ul>
     * <li>true  - if and only if the value matches the upper bound</li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    @Nonnull
    default Boolean matchesUpper(T value, @Nonnull Comparator< T > comparator) {

        T upperValue = getUpperBoundValue();

        int result = comparator.compare(upperValue, value);

        if (getUpperKind() == Bound.BoundKind.INCLUSIVE) {
            return result >= 0;
        }

        return result > 0;
    }


    /**
     * Returns the value of the upper bound
     *
     * @return the value of the upper bound
     *
     * @see Bound#getBoundValue()
     * @since 0.0.6
     */
    T getUpperBoundValue();


    /**
     * Returns the upper bound of this interval
     *
     * @return the upper bound
     *
     * @since 0.0.6
     */
    Bound< T > getUpperBound();


    /**
     * Returns the {@link BoundKind} of the upper {@link Bound}
     *
     * @return the {@link BoundKind} of the upper {@link Bound}
     *
     * @since 0.0.6
     */
    BoundKind getUpperKind();


    /**
     * A default method to check whether a provided value matches the lower bound, based on a passed {@link Comparator}
     *
     * @param value      the value
     * @param comparator the comparator, which is specialized for the underlying type of this interval
     *
     * @return <ul>
     * <li>true  - if and only if the value matches the lower bound</li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    @Nonnull
    default Boolean matchesLower(T value, @Nonnull Comparator< T > comparator) {

        T lowerValue = getLowerBoundValue();

        int result = comparator.compare(lowerValue, value);

        if (getLowerKind() == Bound.BoundKind.INCLUSIVE) {
            return result <= 0;
        }

        return result < 0;
    }


    /**
     * Returns the lower bound of this interval
     *
     * @return the lower bound
     *
     * @since 0.0.6
     */
    Bound< T > getLowerBound();


    /**
     * Returns the value of the lower bound
     *
     * @return the value of the lower bound
     *
     * @see Bound#getBoundValue()
     * @since 0.0.6
     */
    T getLowerBoundValue();


    /**
     * Returns the {@link BoundKind} of the lower {@link Bound}
     *
     * @return the {@link BoundKind} of the lower {@link Bound}
     *
     * @since 0.0.6
     */
    BoundKind getLowerKind();

}
