package tomconn.growthapi.implementations.growthprofile.probability;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.growthprofile.probability.interval.SaplingIntervalProbabilityHelper;
import tomconn.growthapi.implementations.growthprofile.probability.tuple.SaplingTupleProbabilityHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.PrimitiveProabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Objects;


public class SaplingProbabilityFunctionHelper implements PrimitiveProabilityFunctionHelper< SaplingGrowTreeEvent > {

    @Nonnull
    private final SaplingTupleProbabilityHelper tupleHelper;
    @Nonnull
    private final SaplingIntervalProbabilityHelper intervalHelper;


    {
        tupleHelper = new SaplingTupleProbabilityHelper();
        intervalHelper = new SaplingIntervalProbabilityHelper();
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, Interval< BlockPos > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.blockPosIntervalChance(intervals);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, Interval< Integer > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.lightLevelIntervalChance(intervals);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, Interval< Float > > > intervals) {

        Objects.requireNonNull(intervals);
        return intervalHelper.temperatureIntervalChance(intervals);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.biomeTupledChance(tuples);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.blockPosTupleChance(tuples);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.lightLevelTupleChance(tuples);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > skyChance(double ifCanSee, double ifCannotSee) {

        return tupleHelper.skyChance(ifCanSee, ifCannotSee);
    }


    @Override
    public ProbabilityFunction< SaplingGrowTreeEvent > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float > > > tuples) {

        return tupleHelper.temperatureTupleChance(tuples);
    }

}
