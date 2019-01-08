package tomconn.growthapi.implementations.growthprofile.probability;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.probability.interval.CropIntervalProbabilityFunctionHelper;
import tomconn.growthapi.implementations.growthprofile.probability.tuple.CropTupleProbabilityHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.PrimitiveProabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.NumberInterval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.PrimitiveBlockPosInterval;

import java.util.Collection;
import java.util.Objects;


/**
 * This class is supposed to help with creating {@link ProbabilityFunction}s for the {@link Pre} event
 *
 * @since 0.0.6
 */
public class CropProbabilityFunctionHelper implements PrimitiveProabilityFunctionHelper< Pre > {

    private final CropIntervalProbabilityFunctionHelper intervalHelper;
    private final CropTupleProbabilityHelper tupleHelper;


    {
        intervalHelper = new CropIntervalProbabilityFunctionHelper();
        tupleHelper = new CropTupleProbabilityHelper();
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > blockPosIntervalChance(Collection< ProbabilityFunctionTuple< BlockPos, PrimitiveBlockPosInterval > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.blockPosIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > lightLevelIntervalChance(Collection< ProbabilityFunctionTuple< Integer, NumberInterval< Integer > > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.lightLevelIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > temperatureIntervalChance(Collection< ProbabilityFunctionTuple< Float, NumberInterval< Float > > > intervals) {

        Objects.requireNonNull(intervals);

        return intervalHelper.temperatureIntervalChance(intervals);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome > > > tuples) {

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
    public ProbabilityFunction< Pre > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.blockPosTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.lightLevelTupleChance(tuples);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > skyChance(double ifCanSee, double ifCannotSee) {

        return tupleHelper.skyChance(ifCanSee, ifCannotSee);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< Pre > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float > > > tuples) {

        Objects.requireNonNull(tuples);
        return tupleHelper.temperatureTupleChance(tuples);
    }

}
