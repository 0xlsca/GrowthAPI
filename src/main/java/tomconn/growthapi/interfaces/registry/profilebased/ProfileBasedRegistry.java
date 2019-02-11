package tomconn.growthapi.interfaces.registry.profilebased;

import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.pre.ProfilePreMethods;
import tomconn.growthapi.interfaces.registry.profilebased.sapling.ProfileSaplingMethods;

/**
 * This interface defines functionality which is needed to hold all
 * {@link BaseGrowthProfile} in one place and have them easily accessible
 * from other places within the library.
 *
 * @since 0.0.5
 */
public interface ProfileBasedRegistry extends
        ProfilePreMethods,
        ProfileSaplingMethods {
}
