package tomconn.growthapi.implementations.growthprofile.probability.math;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

import java.util.Objects;

/**
 * Default implementation of {@link ProbabilityFunctionTuple}
 *
 * @param <T> the type of the domain
 * @param <C> the container in which the domain-value is stored
 *
 * @since 0.0.6
 */
class FunctionTuple< T, C extends DomainContainer< T > > implements ProbabilityFunctionTuple< T, C > {


    private final C container;
    private final Probability probability;


    /**
     * Default constructor.
     *
     * @param container   the container
     * @param probability the probability
     *
     * @since 0.0.6
     */
    FunctionTuple(C container, Probability probability) {

        Objects.requireNonNull(container);

        this.container = container;
        this.probability = probability;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public C getDomainContainer() {

        return container;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Probability getProbability() {

        return probability;
    }

}
