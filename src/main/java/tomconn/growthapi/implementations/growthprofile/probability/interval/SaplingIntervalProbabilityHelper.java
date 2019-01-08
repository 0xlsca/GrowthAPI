package tomconn.growthapi.implementations.growthprofile.probability.interval;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.growthprofile.probability.CropProbabilityFunctionHelper;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.PrimitiveIntervalProbabilityFunctionHelper;

/**
 * This class is a delegate of {@link CropProbabilityFunctionHelper} and covers all methods of the
 * {@link PrimitiveIntervalProbabilityFunctionHelper}-interface in respect of the {@link SaplingGrowTreeEvent}
 *
 * @since 0.0.6
 */
public class SaplingIntervalProbabilityHelper extends IntervalProbabilityFunctionHelper< SaplingGrowTreeEvent > {


}
