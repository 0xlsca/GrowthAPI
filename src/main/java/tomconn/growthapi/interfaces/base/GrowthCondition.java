package tomconn.growthapi.interfaces.base;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A growth condition is a {@link Predicate} which is specialized for growth processes
 *
 * @since 0.0.6
 */
public interface GrowthCondition< E extends Event > extends Predicate< E > {

    /**
     * Applies AND-logic to this and the passed other  {@link GrowthCondition}
     *
     * @param other the other condition
     *
     * @return a new {@link GrowthCondition} which will represent boolean logic that is equivalent to
     * <br>
     * <br>
     * {@code this.test(event) && other.test(event) }
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > and(GrowthCondition< E > other) {

        Objects.requireNonNull(other);
        return e -> this.test(e) && other.test(e);
    }


    /**
     * Applies OR-logic to this and the passed other  {@link GrowthCondition}
     *
     * @param other the other condition
     *
     * @return a new {@link GrowthCondition} which will represent boolean logic that is equivalent to
     * <br>
     * <br>
     * {@code this.test(event) || other.test(event) }
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > or(GrowthCondition< E > other) {

        Objects.requireNonNull(other);
        return e -> this.test(e) || other.test(e);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > negate() {

        return e -> !this.test(e);
    }

}
