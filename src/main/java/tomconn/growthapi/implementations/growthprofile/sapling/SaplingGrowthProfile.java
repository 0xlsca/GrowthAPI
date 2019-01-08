package tomconn.growthapi.implementations.growthprofile.sapling;


import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.implementations.growthprofile.BaseGrowthProfile;
import tomconn.growthapi.implementations.requirementhelpers.sapling.SaplingGrowTreeRequirementHelper;

public class SaplingGrowthProfile extends BaseGrowthProfile< SaplingGrowTreeEvent > {

    public SaplingGrowthProfile() {
        super(new SaplingGrowTreeRequirementHelper());
    }
}
