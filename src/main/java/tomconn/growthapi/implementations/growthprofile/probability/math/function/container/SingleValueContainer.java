package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Objects;

/**
 * Default implementation of {@link SingleValueDomainContainer}
 *
 * @param <T> the type of the domain
 *
 * @implNote {@link #isValuePresent(Object)} is implemented by calling {@link Object#equals(Object)} of the contained
 * value
 * @since 0.0.6
 */
public class SingleValueContainer< T > implements SingleValueDomainContainer< T > {

    private final T value;


    /**
     * Default constructor
     *
     * @param value sets the value for this container to the passed parameter
     *
     * @since 0.0.6
     */
    public SingleValueContainer(T value) {

        Objects.requireNonNull(value);
        this.value = value;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public boolean isValuePresent(T value) {

        Objects.requireNonNull(value);
        return this.value.equals(value);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public T getValue() {

        return value;
    }

}
