package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import net.minecraft.util.math.BlockPos;
import tomconn.growthapi.implementations.growthprofile.probability.math.function.container.AbstractInterval.DefaultBound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound.BoundKind;

import java.util.Comparator;
import java.util.Objects;

/**
 * This class is an entry point for all {@link DomainContainer} related implementations
 *
 * @since 0.0.6
 */
public interface DomainContainers {

    /**
     * Returns a new {@link SingleValueDomainContainer} instance which contains the passed value
     *
     * @param value the value which the new container shall hold
     * @param <T>   the type of the value
     *
     * @return a new {@link SingleValueDomainContainer}
     *
     * @since 0.0.6
     */
    static < T > SingleValueContainer< T > singleContainerOf(T value) {

        Objects.requireNonNull(value);

        return new SingleValueContainer<>(value);
    }


    /**
     * Returns a new {@link Interval} instance which contains the passed value
     *
     * @param upper      the upper bound of the interval
     * @param lower      the lower bound of the interval
     * @param comparator a comparator which is used for deciding whether a value is within the specified bounds
     * @param <T>        the underlying type of the interval
     *
     * @return a new {@link Interval} which contains the passed values
     *
     * @since 0.0.6
     */
    static < T > Interval< T > intervalOf(Bound< T > upper, Bound< T > lower, Comparator< T > comparator) {

        Objects.requireNonNull(upper);
        Objects.requireNonNull(lower);
        Objects.requireNonNull(comparator);

        return new DefaultInterval<>(upper, lower, comparator);
    }


    /**
     * Overloaded wrapper for {@link #intervalOf(Bound, Bound, Comparator)}
     *
     * @param upperValue the value of the upper {@link Bound}
     * @param upperKind  the {@link BoundKind} of the upper {@link Bound}
     * @param lowerValue the value of the lower {@link Bound}
     * @param lowerKind  the {@link BoundKind} of the lower {@link Bound}
     * @param comparator a comparator which is specialized for the underlying type of the {@link Interval}
     * @param <T>        the underlying type of the {@link Interval}
     *
     * @return an instance of {@link Interval} which contains the specified values
     *
     * @since 0.0.6
     */
    static < T > Interval< T > intervalOf(T upperValue, BoundKind upperKind, T lowerValue, BoundKind lowerKind, Comparator< T > comparator) {

        Objects.requireNonNull(upperValue);
        Objects.requireNonNull(upperKind);

        Objects.requireNonNull(lowerValue);
        Objects.requireNonNull(lowerKind);

        return intervalOf(boundOf(upperValue, upperKind), boundOf(lowerValue, lowerKind), comparator);
    }


    /**
     * Returns a new {@link Interval} which is specialized for {@link BlockPos}es.
     * <p>
     * This kind of {@link Interval} depicts a cuboid in Minecraft.
     *
     * @param upper the upper bound
     * @param lower the lower bound
     *
     * @return a new {@link Interval}
     *
     * @since 0.0.6
     */
    static Interval< BlockPos > blockPosIntervalOf(Bound< BlockPos > upper, Bound< BlockPos > lower) {

        Objects.requireNonNull(upper);
        Objects.requireNonNull(lower);

        return new BlockPosInterval(upper, lower);
    }


    /**
     * A overloaded wrapper for {@link #blockPosIntervalOf(Bound, Bound)}
     *
     * @param upperValue the value of the upper {@link Bound}
     * @param upperKind  the {@link BoundKind} of the upper {@link Bound}
     * @param lowerValue the value of the lower {@link Bound}
     * @param lowerKind  the {@link BoundKind} of the lower {@link Bound}
     *
     * @return an instance of {@link Interval} which is specialized for {@link BlockPos}es
     *
     * @since 0.0.6
     */
    static Interval< BlockPos > blockPosIntervalOf(BlockPos upperValue, BoundKind upperKind, BlockPos lowerValue, BoundKind lowerKind) {

        Objects.requireNonNull(upperValue);
        Objects.requireNonNull(lowerValue);

        Objects.requireNonNull(upperKind);
        Objects.requireNonNull(lowerKind);


        return blockPosIntervalOf(boundOf(upperValue, upperKind), boundOf(lowerValue, lowerKind));
    }


    /**
     * Returns a new instance of {@link Bound} which contains the passed values
     *
     * @param value the value of the returned {@link Bound}
     * @param kind  the {@link BoundKind} of the returned {@link Bound}
     * @param <T>   the underlying type of the returned {@link Bound}
     *
     * @return a {@link Bound} with the specified attributes
     *
     * @since 0.0.6
     */
    static < T > Bound< T > boundOf(T value, BoundKind kind) {

        Objects.requireNonNull(value);
        Objects.requireNonNull(kind);

        return new DefaultBound<>(value, kind);
    }


    /**
     * A wrapper for {@link #boundOf(Object, BoundKind)} which pre-sets the {@link BoundKind} to {@link
     * BoundKind#INCLUSIVE}
     *
     * @param value the value of the returned {@link Bound}
     * @param <T>   the underlying type of the returned {@link Bound}
     *
     * @return a {@link Bound} with the specified value
     */
    static < T > Bound< T > boundOfInclusive(T value) {

        Objects.requireNonNull(value);

        return new DefaultBound<>(value, BoundKind.INCLUSIVE);
    }


    /**
     * A wrapper for {@link #boundOf(Object, BoundKind)} which pre-sets the {@link BoundKind} to {@link
     * BoundKind#EXCLUSIVE}
     *
     * @param value the value of the returned {@link Bound}
     * @param <T>   the underlying type of the returned {@link Bound}
     *
     * @return a {@link Bound} with the specified value
     */
    static < T > Bound< T > boundOfExclusive(T value) {

        Objects.requireNonNull(value);

        return new DefaultBound<>(value, BoundKind.EXCLUSIVE);
    }

}
