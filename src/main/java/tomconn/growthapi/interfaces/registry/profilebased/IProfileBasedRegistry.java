package tomconn.growthapi.interfaces.registry.profilebased;

import tomconn.growthapi.interfaces.registry.profilebased.pre.IPBRPreMethods;
import tomconn.growthapi.interfaces.registry.profilebased.sapling.IPBRSaplingMethods;

/**
 * This interface defines functionality which is needed to hold all
 * {@link tomconn.growthapi.interfaces.growthprofile.IGrowthProfile} in one place and have them easily accessible
 * from other places within the library.
 */
public interface IProfileBasedRegistry extends
        IPBRPreMethods,
        IPBRSaplingMethods {
}
