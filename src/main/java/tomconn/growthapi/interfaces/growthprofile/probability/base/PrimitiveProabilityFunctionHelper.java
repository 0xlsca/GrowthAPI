package tomconn.growthapi.interfaces.growthprofile.probability.base;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.PrimitiveIntervalProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.PrimitiveTupleProbabilityFunctionHelper;

/**
 * This interface unifies all chance-function-methods in one type
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface PrimitiveProabilityFunctionHelper< E extends Event > extends
        PrimitiveTupleProbabilityFunctionHelper< E >,
        PrimitiveIntervalProbabilityFunctionHelper< E > {

}
