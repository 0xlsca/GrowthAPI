package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

class DefaultIntervalTest< T > extends AbstractIntervalTest< T > {

    private final Function< T, T > inverter;
    private final Comparator< T > comparator;


    protected DefaultIntervalTest(T value, Function< T, T > inverter, Comparator< T > comparator) {

        super(inverter, value);

        Objects.requireNonNull(value);
        Objects.requireNonNull(inverter);
        Objects.requireNonNull(comparator);

        this.inverter = inverter;
        this.comparator = comparator;
    }


    @Override
    Interval< T > makeInterval(Bound< T > upper, Bound< T > lower) {

        Objects.requireNonNull(upper);
        Objects.requireNonNull(lower);

        return DomainContainers.intervalOf(upper, lower, comparator);
    }

}