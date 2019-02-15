package tomconn.growthapi.implementations.registry;

import tomconn.growthapi.interfaces.registry.UnifiedRegistry;
import tomconn.growthapi.interfaces.registry.classbased.ClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

/**
 * This interface provides static-level entry-points for obtaining registry-instances
 *
 * @since 0.0.6
 */
public interface Registries {

    /**
     * Returns a new instance of {@link ClassBasedRegistry}
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    static ClassBasedRegistry newClassBasedRegistry() {

        return new DefaultClassBasedRegistry();
    }


    /**
     * Returns a new instance of {@link ProfileBasedRegistry}
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    static ProfileBasedRegistry newProfileBasedRegistry() {

        return new DefaultProfileRegistry();
    }


    /**
     * Returns a new instance of {@link UnifiedRegistry}
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    static UnifiedRegistry newUnifiedRegistry() {

        return new DefaultUnifiedRegistry();
    }

}
