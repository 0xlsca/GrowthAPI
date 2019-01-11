package tomconn.growthapi.interfaces.registry.profilebased;

import tomconn.growthapi.interfaces.growthprofile.BaseGrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.pre.IPBRPreMethods;
import tomconn.growthapi.interfaces.registry.profilebased.sapling.IPBRSaplingMethods;

/**
 * This interface defines functionality which is needed to hold all
 * {@link BaseGrowthProfile} in one place and have them easily accessible
 * from other places within the library.
 */
public interface ProfileBasedRegistry extends
        IPBRPreMethods,
        IPBRSaplingMethods {
}
