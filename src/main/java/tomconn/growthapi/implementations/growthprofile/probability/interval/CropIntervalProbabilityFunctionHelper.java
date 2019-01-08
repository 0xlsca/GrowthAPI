package tomconn.growthapi.implementations.growthprofile.probability.interval;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.probability.CropProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.PrimitiveIntervalProbabilityFunctionHelper;

/**
 * This class is a delegate of {@link CropProbabilityFunctionHelper} and covers all methods of the
 * {@link PrimitiveIntervalProbabilityFunctionHelper}-interface in respect of the {@link Pre}-event
 *
 * @since 0.0.6
 */
public class CropIntervalProbabilityFunctionHelper extends IntervalProbabilityFunctionHelper< Pre > {


}
