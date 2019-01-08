package tomconn.growthapi.implementations.growthprofile.probability.interval;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.growthprofile.probability.ProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.PrimitiveIntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.NumberInterval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.PrimitiveBlockPosInterval;

import java.util.Collection;
import java.util.Objects;

/**
 * This class provides basic methods which help with tailoring {@link Interval}-based {@link ProbabilityFunction}s
 *
 * @since 0.0.6
 */
public abstract class IntervalProbabilityFunctionHelper< E extends Event > extends ProbabilityFunctionHelper< E > implements PrimitiveIntervalProbabilityFunctionHelper< E > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, PrimitiveBlockPosInterval > > intervals) {

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
    public ProbabilityFunction< E > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, NumberInterval< Integer > > > intervals) {

        Objects.requireNonNull(intervals);

        return tailorFunction(intervals, e -> supplyHelper(e).getLightLevel());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, NumberInterval< Float > > > intervals) {

        Objects.requireNonNull(intervals);


        return tailorFunction(intervals, e -> supplyHelper(e).getTemperature());
    }

}
