package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.growthprofile.probability.function_helpers.AbstractProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Collection;
import java.util.Objects;

/**
 * This class provides basic methods which help with tailoring {@link Interval}-based {@link ProbabilityFunction}s.<br>
 * It is a skeleton class of {@link IntervalProbabilityFunctionHelper}.
 *
 * @since 0.0.6
 */
abstract class AbstractIntervalProbabilityFunctionHelper< E extends Event > extends AbstractProbabilityFunctionHelper< E > implements IntervalProbabilityFunctionHelper< E > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, Interval< BlockPos >, ? > > intervals) {

        Objects.requireNonNull(intervals);

        return tailorFunction(intervals, e -> supplyHelper(e).getBlockBos());
    }


    /**
     * {@inheritDoc}
     *
     * @param intervals
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, Interval< Integer >, ? > > intervals) {

        Objects.requireNonNull(intervals);

        return tailorFunction(intervals, e -> supplyHelper(e).getLightLevel());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, Interval< Float >, ? > > intervals) {

        Objects.requireNonNull(intervals);


        return tailorFunction(intervals, e -> supplyHelper(e).getTemperature());
    }

}
