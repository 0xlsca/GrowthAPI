package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.event.helper.EventHelpers;
import tomconn.growthapi.interfaces.event.helper.BaseEventHelper;
import tomconn.growthapi.interfaces.requirementhelpers.BaseRequirementHelper;


/**
 * A {@link Pre}-based implementation of {@link BaseRequirementHelper}
 *
 * @since 0.0.5
 */
class CropGrowPreRequirementHelper implements BaseRequirementHelper< Pre > {


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public BaseEventHelper supplyHelper(Pre event) {

        return EventHelpers.cropPre(event);
    }

}