package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.temperature;

import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Arrays;
import java.util.Collection;

/**
 * {@link Tuple}-based methods which help with creating {@link ProbabilityFunction}s
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface TemperatureTupleProbabilityMethods< E extends Event > {


    /**
     * This method tailors a {@link ProbabilityFunction} based on {@link Tuple}s
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}, based on the passed tuples
     *
     * @since 0.0.6
     */
    default ProbabilityFunction< E > temperatureTupleChance(ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float >, ? >... tuples) {

        return temperatureTupleChance(Arrays.asList(tuples));
    }


    /**
     * This method tailors a {@link ProbabilityFunction} based on {@link Tuple}s
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}, based on the passed tuples
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > temperatureTupleChance(Collection< ProbabilityFunctionTuple< Float, SingleValueDomainContainer< Float >, ? > > tuples);

}
