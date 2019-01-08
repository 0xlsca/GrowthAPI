package tomconn.growthapi.interfaces.growthprofile.probability.base.interval.temperature;

import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.NumberInterval;

import java.util.Arrays;
import java.util.Collection;

/**
 * Adds a variety of temperature-based chance-functions
 *
 * @since 0.0.6
 */
public interface TemperatureIntervalProbabilityMethods< E extends Event > {

    /**
     * This method tailors a function which returns a chance-value based on the passed intervals
     *
     * @param intervals the stages, presented as a {@link Tuple}-{@link Collection}
     *
     * @return a function which is based on the passed {@link Collection}
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, NumberInterval< Float > > > intervals);


    /**
     * A vararg-based wrapper for {@link #temperatureIntervalChance(Collection)}
     *
     * @param intervals the stages
     *
     * @return a function which is based on the passed vararg of tuples
     *
     * @see #temperatureIntervalChance(Collection)
     * @since 0.0.6
     */
    default ProbabilityFunction< E > temperatureIntervalChance(ProbabilityFunctionTuple< Float, NumberInterval< Float > >... intervals) {

        return temperatureIntervalChance(Arrays.asList(intervals));
    }


}
