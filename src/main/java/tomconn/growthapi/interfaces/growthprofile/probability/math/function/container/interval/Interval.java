package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

import javax.annotation.Nonnull;
import java.util.Comparator;

/**
 * This interface denotes methods which are required to represent an interval, mathematically speaking
 *
 * @since 0.0.6
 */
public interface Interval< T > extends DomainContainer< T > {


    /**
     * This interface represents a mathematical bound
     *
     * @since 0.0.6
     */
    interface Bound< T > {


        /**
         * Returns the value of this bound
         *
         * @return the value of this bound
         *
         * @since 0.0.6
         */
        T getBoundValue();


        /**
         * Returns the {@link BoundKind} of this bound
         *
         * @return a {@link BoundKind}
         *
         * @since 0.0.6
         */
        BoundKind getBoundKind();


        /**
         * Depicts the kind of a bound.
         *
         * @since 0.0.6
         */
        enum BoundKind {
            INCLUSIVE,
            EXCLUSIVE
        }

    }


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

        T upperValue = getUpperBound().getBoundValue();

        int result = comparator.compare(upperValue, value);

        if (getUpperBound().getBoundKind() == Bound.BoundKind.INCLUSIVE) {
            return result >= 0;
        }

        return result > 0;
    }


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

        T lowerValue = getLowerBound().getBoundValue();

        int result = comparator.compare(lowerValue, value);

        if (getLowerBound().getBoundKind() == Bound.BoundKind.INCLUSIVE) {
            return result <= 0;
        }

        return result < 0;
    }


    /**
     * Returns the upper bound of this interval
     *
     * @return the upper bound
     *
     * @since 0.0.6
     */
    Bound< T > getUpperBound();


    /**
     * Returns the lower bound of this interval
     *
     * @return the lower bound
     *
     * @since 0.0.6
     */
    Bound< T > getLowerBound();

}
