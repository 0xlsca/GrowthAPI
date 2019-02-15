package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.tuple;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.event.helper.EventHelpers;
import tomconn.growthapi.interfaces.event.helper.BaseEventHelper;

import javax.annotation.Nonnull;

/**
 * This class covers all methods of {@link AbstractTupleFunctionHelper} in respect of {@link Pre}
 *
 * @since 0.0.6
 */
class CropTupleProbabilityHelper extends AbstractTupleFunctionHelper< Pre > {


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
