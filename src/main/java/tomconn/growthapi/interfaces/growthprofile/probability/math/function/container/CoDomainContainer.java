package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container;

/**
 * A CoDomainContainer always contains a single value in this case.
 *
 * @param <T>
 *
 * @since 0.0.6
 */
@FunctionalInterface
public interface CoDomainContainer< T > {

    /**
     * Returns the value which is contained
     *
     * @return the value
     *
     * @since 0.0.6
     */
    T getValue();

}
