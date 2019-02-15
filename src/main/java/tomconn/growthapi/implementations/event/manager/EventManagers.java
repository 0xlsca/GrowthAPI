package tomconn.growthapi.implementations.event.manager;

import tomconn.growthapi.implementations.registry.Registries;
import tomconn.growthapi.interfaces.event.manager.EventManager;
import tomconn.growthapi.interfaces.registry.UnifiedRegistry;

import java.util.Objects;

/**
 * Provides static functions to obtain {@link EventManager} instances
 *
 * @since 0.0.6
 */
public interface EventManagers {

    /**
     * Wraps {@link #newManager(UnifiedRegistry)} with a fetched registry from {@link Registries#newUnifiedRegistry()}
     *
     * @return a new {@link EventManager} instance
     *
     * @since 0.0.6
     */
    static EventManager newManager() {

        return new DefaultEventManager(Registries.newUnifiedRegistry());
    }


    /**
     * Creates a new instance with the specified internally held {@link UnifiedRegistry}
     *
     * @param registry the registry
     *
     * @return a new {@link EventManager} instance
     *
     * @since 0.0.6
     */
    static EventManager newManager(UnifiedRegistry registry) {

        Objects.requireNonNull(registry);
        return new DefaultEventManager(registry);
    }


}
