package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound.BoundKind;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Objects;

/**
 * A skeleton class for {@link Interval}
 *
 * @param <T> the type of the interval
 *
 * @since 0.0.6
 */
abstract class AbstractInterval< T > implements Interval< T > {

    private final Bound< T > upperBound;
    private final Bound< T > lowerBound;


    /**
     * Default constructor
     *
     * @param upperBound the upper bound for this {@link Interval}
     * @param lowerBound the lower bound for this {@link Interval}
     *
     * @since 0.0.6
     */
    AbstractInterval(Bound< T > upperBound, Bound< T > lowerBound) {

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
     * {@inheritDoc}
     *
     * @since TODO
     */
    @Override
    public Interval< T > withUpperValue(T value) {

        return withUpperBound(this.upperBound.withValue(value));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Interval< T > withLowerValue(T value) {

        return withLowerBound(this.lowerBound.withValue(value));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public T getUpperBoundValue() {

        return upperBound.getBoundValue();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public BoundKind getUpperKind() {

        return upperBound.getBoundKind();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public T getLowerBoundValue() {

        return lowerBound.getBoundValue();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public BoundKind getLowerKind() {

        return lowerBound.getBoundKind();
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


        /**
         * {@inheritDoc}
         *
         * @since 0.0.6
         */
        @Override
        public T getBoundValue() {

            return value;
        }


        /**
         * {@inheritDoc}
         *
         * @since 0.0.6
         */
        @Override
        public BoundKind getBoundKind() {

            return kind;
        }


        /**
         * {@inheritDoc}
         *
         * @since 0.0.6
         */
        @Override
        public Bound< T > withValue(T value) {

            return new DefaultBound<>(value, this.kind);
        }


        /**
         * {@inheritDoc}
         *
         * @since 0.0.6
         */
        @Override
        public Bound< T > withKind(BoundKind kind) {

            return new DefaultBound<>(this.value, kind);
        }

    }

}
