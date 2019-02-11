package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.event.helpers.EventHelpers;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;

import javax.annotation.Nonnull;

/**
 * This class covers all methods of {@link AbstractIntervalProbabilityFunctionHelper} in respect of {@link
 * SaplingGrowTreeEvent}
 *
 * @since 0.0.6
 */
class SaplingIntervalProbabilityHelper extends AbstractIntervalProbabilityFunctionHelper< SaplingGrowTreeEvent > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    protected BaseEventHelper supplyHelper(@Nonnull SaplingGrowTreeEvent event) {

        return EventHelpers.saplingGrowTree(event);
    }

}
