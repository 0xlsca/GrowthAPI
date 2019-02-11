package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import org.junit.jupiter.api.Test;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static tomconn.growthapi.implementations.growthprofile.probability.math.function.container.DomainContainers.boundOfExclusive;
import static tomconn.growthapi.implementations.growthprofile.probability.math.function.container.DomainContainers.boundOfInclusive;

public abstract class AbstractIntervalTest< T > {

    private final T upperValue;
    private final T lowerValue;

    @Nonnull
    private final Bound< T > upperInclusive;
    @Nonnull
    private final Bound< T > upperExclusive;

    @Nonnull
    private final Bound< T > lowerInclusive;
    @Nonnull
    private final Bound< T > lowerExclusive;


    protected AbstractIntervalTest(@Nonnull Function< T, T > inverter, T value) {

        Objects.requireNonNull(inverter);
        Objects.requireNonNull(value);

        this.upperValue = value;
        this.lowerValue = inverter.apply(value);

        upperInclusive = boundOfInclusive(upperValue);
        upperExclusive = boundOfExclusive(upperValue);

        lowerInclusive = boundOfInclusive(lowerValue);
        lowerExclusive = boundOfExclusive(lowerValue);
    }


    @Test
    void testIsValuePresent() {

        Interval< T > interval;

        interval = makeInterval(upperInclusive, lowerInclusive);
        assertTrue(interval.isValuePresent(upperValue), "Created inclusive upper bound, however the value of the upper bound was marked as not included");
        assertTrue(interval.isValuePresent(lowerValue), "Created inclusive upper bound, however the value of the lower bound was marked as not included");

        interval = makeInterval(upperExclusive, lowerInclusive);
        assertFalse(interval.isValuePresent(upperValue), "Created exclusive upper bound, however the value of the bound was marked as included");
        assertTrue(interval.isValuePresent(lowerValue), "Created inclusive lower bound, however the value of the bound was marked as not included");

        interval = makeInterval(upperInclusive, lowerExclusive);
        assertTrue(interval.isValuePresent(upperValue), "Created inclusive upper bound, however the value of the upper bound was marked as not included");
        assertFalse(interval.isValuePresent(lowerValue), "Created exclusive lower bound, however the value of the bound was marked as included");

        interval = makeInterval(upperExclusive, lowerExclusive);
        assertFalse(interval.isValuePresent(upperValue), "Created exclusive upper bound, however the value of the bound was marked as included");
        assertFalse(interval.isValuePresent(lowerValue), "Created exclusive lower bound, however the value of the bound was marked as included");

    }


    @Test
    void with_upper_works(Interval< T > interval, T differentValue) {

        Objects.requireNonNull(interval);
        Objects.requireNonNull(differentValue);

        assertNotEquals(differentValue, interval.getUpperBoundValue(), "passed value must be different from received one");

        T newValue = interval.withUpperValue(differentValue).getUpperBoundValue();

        assertNotEquals(newValue, interval.getUpperBoundValue(), "used withUpperValue on interval with different value, received same value when querying, however");


    }


    abstract Interval< T > makeInterval(Bound< T > upper, Bound< T > lower);

}
