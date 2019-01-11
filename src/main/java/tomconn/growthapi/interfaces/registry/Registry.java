package tomconn.growthapi.interfaces.registry;

import tomconn.growthapi.interfaces.registry.classbased.IClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

/**
 * Unifies the {@link IClassBasedRegistry} and
 * {@link ProfileBasedRegistry} in one interface
 */
public interface Registry extends IClassBasedRegistry, ProfileBasedRegistry {
}
