package tomconn.growthapi.implementations.growthprofile;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

/**
 * This class ads static-level entry methods for obtaining instances of {@link GrowthProfile}
 *
 * @since 0.0.6
 */
public interface GrowthProfiles {

    /**
     * Instantiates a new {@link GrowthProfile} which is specialized for the {@link Pre}-event
     *
     * @return a new instance of {@link GrowthProfile}
     *
     * @since 0.0.6
     */
    static GrowthProfile< Pre, ? > cropGrowPre() {

        return new CropGrowthProfile();
    }


    /**
     * Instantiates a new {@link GrowthProfile} which is specialized for the {@link SaplingGrowTreeEvent}-event
     *
     * @return a new instance of {@link GrowthProfile}
     *
     * @since 0.0.6
     */
    static GrowthProfile< SaplingGrowTreeEvent, ? > saplingGrowTree() {

        return new SaplingGrowthProfile();
    }

}
