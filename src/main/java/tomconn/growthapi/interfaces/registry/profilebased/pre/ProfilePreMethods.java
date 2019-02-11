package tomconn.growthapi.interfaces.registry.profilebased.pre;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

/**
 * Bundles all {@link GrowthProfile} based, {@link Pre}-related registry interfaces
 *
 * @since 0.0.5
 */
public interface ProfilePreMethods extends ProfilePreRegistration, ProfilePreRetrieval {
}
