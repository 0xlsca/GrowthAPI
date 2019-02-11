package tomconn.growthapi.interfaces.growthprofile.probability.base;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.TupleProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.MathematicalFunction.MaldefinedProbabilityFunctionException;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.CoDomainContainer;

import java.util.function.Supplier;

/**
 * This interface unifies all chance-function-methods in one type
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface ProbabilityFunctionHelper< E extends Event > extends
        TupleProbabilityFunctionHelper< E >,
        IntervalProbabilityFunctionHelper< E > {


    /**
     * Wraps a passed {@link ProbabilityFunction} in a try-catch block and returns the passed default value if a {@link
     * MaldefinedProbabilityFunctionException} is thrown
     *
     * @param functionSupplier a supplier for the function
     * @param probability      the default value
     *
     * @return the wrapped input-function
     *
     * @since 0.0.6
     */
    default ProbabilityFunction< E > functionWithDefault(
            Supplier< ProbabilityFunction< E > > functionSupplier,
            CoDomainContainer< Probability > probability) {

        return e -> {
            try {
                return functionSupplier.get().apply(e);
            } catch (MaldefinedProbabilityFunctionException e1) {
                return probability;
            }
        };

    }

}
