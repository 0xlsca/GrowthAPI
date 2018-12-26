package tomconn.growthapi.implementations.growthprofile.crop;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.ABaseGrowthProfile;
import tomconn.growthapi.implementations.requirementhelpers.crop.CropGrowPreRequirementHelper;

/**
 * This profile covers all growth related things for crops.
 * It was designed with the option to be extendable.
 * <p>
 * This class incorporates chaining methods, which allow for eased building of distinct profiles.
 */
public class CropGrowthProfile extends ABaseGrowthProfile<Pre> {

    public CropGrowthProfile() {
        super(new CropGrowPreRequirementHelper());
    }
}
