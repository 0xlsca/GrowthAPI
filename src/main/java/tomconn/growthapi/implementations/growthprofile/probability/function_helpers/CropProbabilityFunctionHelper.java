package tomconn.growthapi.implementations.growthprofile.probability.function_helpers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval.IntervalHelpers;
import tomconn.growthapi.implementations.growthprofile.probability.function_helpers.tuple.TupleHelpers;
import tomconn.growthapi.interfaces.growthprofile.probability.base.ProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.TupleProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.CoDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Objects;


/**
 * This class is supposed to help with creating {@link ProbabilityFunction}s for the {@link Pre} event
 *
 * @since 0.0.6
 */
class CropProbabilityFunctionHelper implements ProbabilityFunctionHelper< Pre > {

    @Nonnull
    private final IntervalProbabilityFunctionHelper< Pre > intervalHelper;
    @Nonnull
    private final TupleProbabilityFunctionHelper< Pre > tupleHelper;


    {
        intervalHelper = IntervalHelpers.cropHelper();
        tupleHelper = TupleHelpers.cropHelper();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, Interval< BlockPos >, ? > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.blockPosIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, Interval< Integer >, ? > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.lightLevelIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, Interval< Float >, ? > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.temperatureIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome >, ? > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.biomeTupledChance(tuples);

    }


    /**
     * {@inheritDoc}
     *
     * @param tuples
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos >, ? > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.blockPosTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer >, ? > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.lightLevelTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > skyChance(CoDomainContainer< Probability > ifCanSee, CoDomainContainer< Probability > ifCannotSee) {

        return tupleHelper.skyChance(ifCanSee, ifCannotSee);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float >, ? > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.temperatureTupleChance(tuples);
    }

}
