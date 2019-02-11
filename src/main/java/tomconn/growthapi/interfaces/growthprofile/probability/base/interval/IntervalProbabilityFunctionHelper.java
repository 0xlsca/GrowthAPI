package tomconn.growthapi.interfaces.growthprofile.probability.base.interval;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.blockpos.BlockPosIntervalProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.lightlevel.LightLevelIntervalProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.temperature.TemperatureIntervalProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

/**
 * Unifies all {@link Interval}-based
 * {@link ProbabilityFunction}-interfaces
 *
 * @since 0.0.6
 */
public interface IntervalProbabilityFunctionHelper< E extends Event > extends
        LightLevelIntervalProbabilityMethods< E >,
        BlockPosIntervalProbabilityMethods< E >,
        TemperatureIntervalProbabilityMethods< E > {

}
