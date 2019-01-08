package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container;

/**
 * A <code>SingleValueDomainContainer</code> contains a single domain-element
 *
 * @param <T> the type of the domain
 *
 * @since 0.0.6
 */
public interface SingleValueDomainContainer< T > extends DomainContainer< T > {

    /**
     * Retuns the value of this container
     *
     * @return the value
     *
     * @since 0.0.6
     */
    T getValue();

}
