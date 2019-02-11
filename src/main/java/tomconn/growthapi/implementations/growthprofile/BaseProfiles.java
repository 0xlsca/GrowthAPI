package tomconn.growthapi.implementations.growthprofile;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;

/**
 * This class ads static-level entry methods for obtaining instances of {@link BaseGrowthProfile}
 *
 * @since 0.0.6
 */
public interface BaseProfiles {

    /**
     * Instantiates a new {@link BaseGrowthProfile} which is specialized for the {@link Pre}-event
     *
     * @return a new instance of {@link BaseGrowthProfile}
     *
     * @since 0.0.6
     */
    static BaseGrowthProfile< Pre, ? > cropGrowPre() {

        return new CropGrowthProfile();
    }


    /**
     * Instantiates a new {@link BaseGrowthProfile} which is specialized for the {@link SaplingGrowTreeEvent}-event
     *
     * @return a new instance of {@link BaseGrowthProfile}
     *
     * @since 0.0.6
     */
    static BaseGrowthProfile< SaplingGrowTreeEvent, ? > saplingGrowTree() {

        return new SaplingGrowthProfile();
    }

}
