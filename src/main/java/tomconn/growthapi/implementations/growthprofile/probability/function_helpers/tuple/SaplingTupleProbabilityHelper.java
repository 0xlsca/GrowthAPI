package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.tuple;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.event.helpers.EventHelpers;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;

import javax.annotation.Nonnull;

/**
 * This class covers all methods of {@link AbstractTupleFunctionHelper} in respect of {@link
 * SaplingGrowTreeEvent}
 *
 * @since 0.0.6
 */
class SaplingTupleProbabilityHelper extends AbstractTupleFunctionHelper< SaplingGrowTreeEvent > {


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
