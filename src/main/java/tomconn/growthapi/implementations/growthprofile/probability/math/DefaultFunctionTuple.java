package tomconn.growthapi.implementations.growthprofile.probability.math;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.CoDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

import java.util.Objects;

/**
 * Default implementation of {@link ProbabilityFunctionTuple}
 *
 * @param <T> the type of the domain
 * @param <D> the container in which the domain-value is stored
 *
 * @since 0.0.6
 */
class DefaultFunctionTuple< T, D extends DomainContainer< T >, C extends CoDomainContainer< Probability > > implements ProbabilityFunctionTuple< T, D, C > {


    private final D container;
    private final C probability;


    /**
     * Default constructor.
     *
     * @param domain   the domain
     * @param probability the probability
     *
     * @since 0.0.6
     */
    DefaultFunctionTuple(D domain, C probability) {

        Objects.requireNonNull(domain);

        this.container = domain;
        this.probability = probability;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public D getDomainContainer() {

        return container;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public C getProbabilityContainer() {

        return probability;
    }

}
