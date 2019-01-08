package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

/**
 * This interface denotes methods which are required to represent an interval, mathematically speaking
 *
 * @since 0.0.6
 */
public interface Interval< T > extends DomainContainer< T > {

    /**
     * Depicts the kind of a bound.
     *
     * @since 0.0.6
     */
    enum BoundKind {
        INCLUSIVE,
        EXCLUSIVE
    }


    /**
     * Returns the upper bound of this interval
     *
     * @return the upper bound
     *
     * @since 0.0.6
     */
    T getUpperBound();


    /**
     * Returns the {@link BoundKind} of the upper bound
     *
     * @return the {@link BoundKind} of the upper bound
     *
     * @since 0.0.6
     */
    BoundKind getUpperBoundKind();


    /**
     * Returns the lower bound of this interval
     *
     * @return the lower bound
     *
     * @since 0.0.6
     */
    T getLowerBound();


    /**
     * Returns the {@link BoundKind} of the lower bound
     *
     * @return the {@link BoundKind} of the lower bound
     *
     * @since 0.0.6
     */
    BoundKind getLowerBoundKind();

}
