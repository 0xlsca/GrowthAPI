package tomconn.growthapi.implementations.growthprofile.probability.tuple;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.growthprofile.probability.ProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.PrimitiveTupleProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static tomconn.growthapi.implementations.growthprofile.probability.math.DomainContainers.singleContainerOf;
import static tomconn.growthapi.implementations.growthprofile.probability.math.ProbabilityFunctions.tupleOf;

/**
 * This class helps with tailoring {@link ProbabilityFunctionTuple}-based {@link ProbabilityFunction}s
 *
 * @param <E> any subtype of {@link Event}
 *
 * @since 0.0.6
 */
public abstract class TupleProbabilityFunctionHelper< E extends Event > extends ProbabilityFunctionHelper< E > implements PrimitiveTupleProbabilityFunctionHelper< E > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome > > > tuples) {

        Objects.requireNonNull(tuples);
        return tailorFunction(tuples, e -> supplyHelper(e).getBiome());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos > > > tuples) {

        Objects.requireNonNull(tuples);
        return tailorFunction(tuples, e -> supplyHelper(e).getBlockBos());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer > > > tuples) {

        Objects.requireNonNull(tuples);
        return tailorFunction(tuples, e -> supplyHelper(e).getLightLevel());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > skyChance(double ifCanSee, double ifCannotSee) {

        Collection< ProbabilityFunctionTuple< Boolean, SingleValueDomainContainer< Boolean > > > tuples =
                Arrays.asList(
                        tupleOf(singleContainerOf(true), ifCanSee),
                        tupleOf(singleContainerOf(false), ifCannotSee)
                );

        return tailorFunction(tuples, e -> supplyHelper(e).canSeeSky());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public ProbabilityFunction< E > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float > > > tuples) {

        Objects.requireNonNull(tuples);
        return tailorFunction(tuples, e -> supplyHelper(e).getTemperature());
    }

}
