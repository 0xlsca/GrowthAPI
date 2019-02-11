package tomconn.growthapi.implementations.growthprofile.probability.function_helpers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval.IntervalHelpers;
import tomconn.growthapi.implementations.growthprofile.probability.function_helpers.tuple.TupleHelpers;
import tomconn.growthapi.interfaces.growthprofile.probability.base.ProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.TupleProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Objects;

/**
 * An implementation of {@link ProbabilityFunctionHelper} for the {@link SaplingGrowTreeEvent}.
 *
 * @since 0.0.6
 */
class SaplingProbabilityFunctionHelper implements ProbabilityFunctionHelper< SaplingGrowTreeEvent > {

    @Nonnull
    private final TupleProbabilityFunctionHelper< SaplingGrowTreeEvent > tupleHelper;
    @Nonnull
    private final IntervalProbabilityFunctionHelper< SaplingGrowTreeEvent > intervalHelper;


    {
        tupleHelper = TupleHelpers.saplingHelper();
        intervalHelper = IntervalHelpers.saplingHelper();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, Interval< BlockPos > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.blockPosIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, Interval< Integer > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.lightLevelIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, Interval< Float > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.temperatureIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.biomeTupledChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.blockPosTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.lightLevelTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > skyChance(Probability ifCanSee, Probability ifCannotSee) {

        return tupleHelper.skyChance(ifCanSee, ifCannotSee);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float > > > tuples) {

        return tupleHelper.temperatureTupleChance(tuples);
    }

}
