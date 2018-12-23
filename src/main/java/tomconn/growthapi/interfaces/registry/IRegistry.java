package tomconn.growthapi.interfaces.registry;

import tomconn.growthapi.interfaces.registry.classbased.IClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

/**
 * Unifies the {@link tomconn.growthapi.interfaces.registry.classbased.IClassBasedRegistry} and
 * {@link IProfileBasedRegistry} in one interface
 */
public interface IRegistry extends IClassBasedRegistry, IProfileBasedRegistry {
}
