package tomconn.growthapi.interfaces.growthprofile.probability.base;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.TupleProbabilityFunctionHelper;

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

}
