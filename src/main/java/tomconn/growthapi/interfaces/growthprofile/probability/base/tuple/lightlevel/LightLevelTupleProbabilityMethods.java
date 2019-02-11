package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.lightlevel;

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
public interface LightLevelTupleProbabilityMethods< E extends Event > {


    /**
     * This method tailors a {@link ProbabilityFunction} based on {@link ProbabilityFunctionTuple}s
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}, based on the passed tuples
     *
     * @since 0.0.6
     */
    default ProbabilityFunction< E > lightLevelTupleChance(ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer >, ? >... tuples) {

        return lightLevelTupleChance(Arrays.asList(tuples));
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
    ProbabilityFunction< E > lightLevelTupleChance(Collection< ProbabilityFunctionTuple< Integer, SingleValueDomainContainer< Integer >, ? > > tuples);

}
