package tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval;


/**
 * This interface represents a mathematical bound
 *
 * @since 0.0.6
 */
public interface Bound< T > {


    /**
     * Returns the value of this bound
     *
     * @return the value of this bound
     *
     * @since 0.0.6
     */
    T getBoundValue();


    /**
     * Returns the {@link BoundKind} of this bound
     *
     * @return a {@link BoundKind}
     *
     * @since 0.0.6
     */
    BoundKind getBoundKind();


    /**
     * <p>Returns a copy of this instance with the set value.</p>
     * <p>The {@link BoundKind} will be copied into the copy.</p>
     *
     * @param value the new value
     *
     * @return a new instance with the set value
     *
     * @since 0.0.6
     */
    Bound< T > withValue(T value);


    /**
     * <p>Returns a copy of this instance with the set {@link BoundKind}.</p>
     * <p>The value of this bound will be copied into the copy.</p>
     *
     * @param kind the new {@link BoundKind}
     *
     * @return a new instance with the set {@link BoundKind}
     *
     * @since 0.0.6
     */
    Bound< T > withKind(BoundKind kind);


    /**
     * Depicts the kind of a bound.
     *
     * @since 0.0.6
     */
    enum BoundKind {
        INCLUSIVE,
        EXCLUSIVE
    }

}
