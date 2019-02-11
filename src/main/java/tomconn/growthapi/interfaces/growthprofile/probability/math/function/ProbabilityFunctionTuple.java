package tomconn.growthapi.interfaces.growthprofile.probability.math.function;


import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

/**
 * Instances of this class are used to build {@link ProbabilityFunction}s
 *
 * @param <T> the type of the domain of the associated {@link ProbabilityFunction}
 *
 * @since 0.0.6
 */
public interface ProbabilityFunctionTuple< T, C extends DomainContainer< T > > {

    /**
     * Returns the {@link DomainContainer} of this tuple
     *
     * @return the {@link DomainContainer}
     *
     * @since 0.0.6
     */
    C getDomainContainer();


    /**
     * Returns the chance to which the domain-value maps
     *
     * @return the chance
     *
     * @since 0.0.6
     */
    Probability getProbability();

}
