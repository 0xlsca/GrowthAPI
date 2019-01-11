package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

class DefaultIntervalTest< T > extends AbstractIntervalTest< T > {

    private final Comparator< T > comparator;


    protected DefaultIntervalTest(T value, Function< T, T > inverter, Comparator< T > comparator) {

        super(inverter, value);

        Objects.requireNonNull(value);
        Objects.requireNonNull(inverter);
        Objects.requireNonNull(comparator);

        Function< T, T > inverter1 = inverter;
        this.comparator = comparator;
    }


    @Nonnull
    @Override
    Interval< T > makeInterval(Bound< T > upper, Bound< T > lower) {

        Objects.requireNonNull(upper);
        Objects.requireNonNull(lower);

        return DomainContainers.intervalOf(upper, lower, comparator);
    }

}