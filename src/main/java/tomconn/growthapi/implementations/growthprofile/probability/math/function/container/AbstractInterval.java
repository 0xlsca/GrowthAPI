package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Objects;

/**
 * A skeleton class for {@link Interval}
 *
 * @param <T> the type of the interval
 *
 * @since 0.0.6
 */
public abstract class AbstractInterval< T > implements Interval< T > {

    protected final Bound< T > upperBound;
    protected final Bound< T > lowerBound;


    /**
     * Default constructor
     *
     * @param upperBound the upper bound for this {@link Interval}
     * @param lowerBound the lower bound for this {@link Interval}
     *
     * @since 0.0.6
     */
    protected AbstractInterval(Bound< T > upperBound, Bound< T > lowerBound) {

        Objects.requireNonNull(upperBound);
        Objects.requireNonNull(lowerBound);

        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Bound< T > getUpperBound() {

        return upperBound;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Bound< T > getLowerBound() {

        return lowerBound;
    }


    /**
     * A default implementation for {@link Bound}
     *
     * @param <T> the underlying type of the bound
     *
     * @since 0.0.6
     */
    static class DefaultBound< T > implements Bound< T > {

        private final T value;
        private final BoundKind kind;


        /**
         * Default constructor
         *
         * @param value the value of this bound
         * @param kind  the {@link BoundKind} of this bound
         *
         * @since 0.0.6
         */
        DefaultBound(T value, BoundKind kind) {

            Objects.requireNonNull(value);
            Objects.requireNonNull(kind);

            this.value = value;

            this.kind = kind;
        }


        @Override
        public T getBoundValue() {

            return value;
        }


        @Override
        public BoundKind getBoundKind() {

            return kind;
        }

    }

}
