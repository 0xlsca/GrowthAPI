package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.event.helpers.EventHelpers;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;
import tomconn.growthapi.interfaces.requirementhelpers.BaseRequirementHelper;

/**
 * Helps with tailoring requirements for the {@link SaplingGrowTreeEvent}
 *
 * @since 0.0.5
 */
class SaplingGrowTreeRequirementHelper implements BaseRequirementHelper< SaplingGrowTreeEvent > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public BaseEventHelper supplyHelper(SaplingGrowTreeEvent event) {

        return EventHelpers.saplingGrowTree(event);
    }

}
