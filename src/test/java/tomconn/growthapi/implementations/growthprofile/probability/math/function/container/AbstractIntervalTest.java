package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import org.junit.jupiter.api.Test;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        Function< T, T > inverter1 = inverter;

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


    abstract Interval< T > makeInterval(Bound< T > upper, Bound< T > lower);

}
