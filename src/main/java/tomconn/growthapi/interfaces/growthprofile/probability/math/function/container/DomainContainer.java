package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

/**
 * Classes implementing this interface represent values of a {@link ProbabilityFunction}'s domain
 *
 * @param <T> the type of which an associated {@link ProbabilityFunction}'s domain consists
 *
 * @since 0.0.6
 */
public interface DomainContainer< T > {

    /**
     * Checks whether the passed value is present within this container
     *
     * @param value an arbitrary value
     *
     * @return <ul>
     * <li>
     * true  - if and only if the value is present within this container
     * </li>
     * <li>
     * false - in all other cases
     * </li>
     * </ul>
     */
    boolean isValuePresent(T value);

}
