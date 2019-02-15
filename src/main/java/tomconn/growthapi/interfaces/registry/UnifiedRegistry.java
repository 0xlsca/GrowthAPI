package tomconn.growthapi.interfaces.registry;

import tomconn.growthapi.interfaces.registry.classbased.ClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

/**
 * Unifies all registry-interfaces into one
 *
 * @since 0.0.5
 */
public interface UnifiedRegistry extends ClassBasedRegistry, ProfileBasedRegistry {
}
