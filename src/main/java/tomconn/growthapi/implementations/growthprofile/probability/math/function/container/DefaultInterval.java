package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Comparator;
import java.util.Objects;

/**
 * The default implementation of {@link Interval}
 *
 * @param <T> the underlying type of the interval
 *
 * @since 0.0.6
 */
class DefaultInterval< T > extends AbstractInterval< T > {

    private final Comparator< T > typeComparator;


    /**
     * Default constructor
     *
     * @param upperBound     sets the upper bound to this value
     * @param lowerBound     sets the lower bound to this value
     * @param typeComparator the comparator for the designated type
     *
     * @see Comparable
     * @since 0.0.6
     */
    DefaultInterval(Bound< T > upperBound, Bound< T > lowerBound, Comparator< T > typeComparator) {

        super(upperBound, lowerBound);

        Objects.requireNonNull(upperBound);
        Objects.requireNonNull(lowerBound);

        Objects.requireNonNull(typeComparator);

        this.typeComparator = typeComparator;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public boolean isValuePresent(T value) {

        Objects.requireNonNull(value);

        return matchesLower(value, typeComparator) && matchesUpper(value, typeComparator);

    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Interval< T > withUpperBound(Bound< T > upper) {

        return new DefaultInterval<>(upper, this.getLowerBound(), this.typeComparator);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Interval< T > withLowerBound(Bound< T > lower) {

        return new DefaultInterval<>(this.getUpperBound(), lower, this.typeComparator);
    }

}
