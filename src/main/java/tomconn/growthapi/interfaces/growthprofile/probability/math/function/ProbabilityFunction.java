package tomconn.growthapi.interfaces.growthprofile.probability.math.function;

import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * A <code>ProbabilityFunction</code> is a function which returns a {@link Double}-value between 0 and 1, based on a passed
 * {@link Event}
 *
 * @since 0.0.6
 */
@FunctionalInterface
public interface ProbabilityFunction< E extends Event > extends Function< E, Double > {

    /**
     * {@inheritDoc}
     *
     * @throws MathematicalFunction.MaldefinedProbabilityFunctionException if the function could not return a
     *                                                                     probability for the passed event
     * @throws MathematicalFunction.MissingMappingException                if there was no {@link Double} mapping for
     *                                                                     the passed {@link Event}
     * @since 0.0.6
     */
    @Nonnull
    @Override
    Double apply(E e);

}
