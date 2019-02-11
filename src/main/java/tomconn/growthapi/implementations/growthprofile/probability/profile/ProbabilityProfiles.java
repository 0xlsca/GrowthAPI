package tomconn.growthapi.implementations.growthprofile.probability.profile;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.probability.ProbabilityGrowthProfile;

/**
 * This class provide static endpoints for other classes to instantiate {@link }
 *
 * @since 0.0.6
 */
public interface ProbabilityProfiles {

    /**
     * Returns a new instance of {@link ProbabilityGrowthProfile} which is specialized for the {@link Pre} event
     *
     * @return a new instance, specilized for {@link Pre}
     *
     * @since 0.0.6
     */
    static ProbabilityGrowthProfile< Pre > cropProfile() {

        return new CropProbabilityProfile();
    }


    /**
     * Returns a new instance of {@link ProbabilityGrowthProfile} which is specialized for the {@link
     * SaplingGrowTreeEvent} event
     *
     * @return a new instance, specilized for {@link Pre}
     *
     * @since 0.0.6
     */
    static ProbabilityGrowthProfile< SaplingGrowTreeEvent > saplingProfile() {

        return new SaplingProbabilityProfile();
    }

}
