package tomconn.growthapi.implementations.growthprofile.probability.math;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Objects;

/**
 * This class is an entry point for all {@link DomainContainer} related implementations
 *
 * @since 0.0.6
 */
public interface DomainContainers {

    /**
     * Returns a new {@link SingleValueDomainContainer} instance which contains the passed value
     *
     * @param value the value which the new container shall hold
     * @param <T>   the type of the value
     *
     * @return a new {@link SingleValueDomainContainer}
     *
     * @since 0.0.6
     */
    static < T > SingleValueContainer< T > singleContainerOf(T value) {

        Objects.requireNonNull(value);

        return new SingleValueContainer<>(value);
    }

}
