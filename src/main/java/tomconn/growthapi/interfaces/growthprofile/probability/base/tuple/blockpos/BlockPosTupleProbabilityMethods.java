package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.blockpos;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Arrays;
import java.util.Collection;

/**
 * {@link ProbabilityFunctionTuple}-based methods which help with creating {@link ProbabilityFunction}s
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface BlockPosTupleProbabilityMethods< E extends Event > {

    /**
     * This method tailors a {@link ProbabilityFunction} based on {@link ProbabilityFunctionTuple}s
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}, based on the passed tuples
     *
     * @since 0.0.6
     */
    default ProbabilityFunction< E > blockPosTupleChance(ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos >, ? >... tuples) {

        return blockPosTupleChance(Arrays.asList(tuples));
    }


    /**
     * This method tailors a {@link ProbabilityFunction} based on {@link ProbabilityFunctionTuple}s
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}, based on the passed tuples
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > blockPosTupleChance(Collection< ProbabilityFunctionTuple< BlockPos, SingleValueDomainContainer< BlockPos >, ? > > tuples);

}
