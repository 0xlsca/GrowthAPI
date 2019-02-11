package tomconn.growthapi.implementations.growthprofile.probability.math;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.CoDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

/**
 * This class is an entry point for all probability-function related implementations
 *
 * @since 0.0.6
 */
public interface FunctionTuples {

    /**
     * This is an entry method for optaining instances of {@link ProbabilityFunctionTuple}.
     *
     * @param container   the {@link DomainContainer} of the tuple
     * @param probability the probability of the tuple
     * @param <T>         the type of the domain
     * @param <C>         the {@link DomainContainer}
     *
     * @return a respective {@link ProbabilityFunctionTuple}
     *
     * @since 0.0.6
     */
    static < T, C extends DomainContainer< T > > ProbabilityFunctionTuple< T, C, ? > tupleOf(C container, CoDomainContainer< Probability > probability) {

        return new DefaultFunctionTuple<>(container, probability);
    }

}
