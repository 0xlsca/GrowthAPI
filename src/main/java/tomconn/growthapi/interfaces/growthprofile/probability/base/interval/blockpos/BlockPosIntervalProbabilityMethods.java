package tomconn.growthapi.interfaces.growthprofile.probability.base.interval.blockpos;

import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Adds a variety of {@link BlockPos}-based probability-methods
 *
 * @since 0.0.6
 */
public interface BlockPosIntervalProbabilityMethods< E extends Event > {


    /**
     * A vararg-based wrapper for {@link #blockPosIntervalChance(Collection)}
     *
     * @param intervals the intervals
     *
     * @return a function which is based on the passed vararg of tuples
     *
     * @see #blockPosIntervalChance(Collection)
     * @since 0.0.6
     */
    default ProbabilityFunction< E > blockPosIntervalChance(ProbabilityFunctionTuple< BlockPos, Interval< BlockPos >, ? >... intervals) {

        return blockPosIntervalChance(Arrays.asList(intervals));
    }


    /**
     * This method tailors a function which returns a probability based on the passed intervals
     *
     * @param intervals the intervals, presented as a {@link Tuple}-{@link List}
     *
     * @return a function which is based on the passed {@link Collection}
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, Interval< BlockPos >, ? > > intervals);


}
