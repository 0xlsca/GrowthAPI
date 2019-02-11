package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.event.helpers.EventHelpers;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;

import javax.annotation.Nonnull;

/**
 * This class covers all methods of {@link AbstractIntervalProbabilityFunctionHelper} in respect of {@link Pre}
 *
 * @since 0.0.6
 */
class CropIntervalProbabilityFunctionHelper extends AbstractIntervalProbabilityFunctionHelper< Pre > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    protected BaseEventHelper supplyHelper(@Nonnull Pre event) {

        return EventHelpers.cropPre(event);
    }

}
