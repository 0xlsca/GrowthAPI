package tomconn.growthapi.interfaces.growthprofile.probability.base.interval.lightlevel;

import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Arrays;
import java.util.Collection;

/**
 * Adds a variety of light-level depending chance-functions
 *
 * @since 0.0.6
 */
public interface LightLevelIntervalProbabilityMethods< E extends Event > {

    /**
     * A vararg-based wrapper for {@link #lightLevelIntervalChance(Collection)}
     *
     * @param stages the stages
     *
     * @return a function which is based on the passed vararg of tuples
     *
     * @see #lightLevelIntervalChance(Collection)
     * @since 0.0.6
     */
    default ProbabilityFunction< E > lightLevelIntervalChance(ProbabilityFunctionTuple< Integer, Interval< Integer >, ? >... stages) {

        return lightLevelIntervalChance(Arrays.asList(stages));
    }


    /**
     * This method tailors a function which returns a chance-value based on the passed intervals
     *
     * @param intervals the stages, presented as a {@link Tuple}-{@link Collection}
     *
     * @return a function which is based on the passed {@link Collection}
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, Interval< Integer >, ? > > intervals);

}
