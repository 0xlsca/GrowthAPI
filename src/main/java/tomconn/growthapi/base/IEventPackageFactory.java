package tomconn.growthapi.base;

import net.minecraftforge.fml.common.eventhandler.Event;

@FunctionalInterface
public interface IEventPackageFactory<E extends Event, P extends IEventPackage<E>> {

    /**
     * Manufactures a package based on the event
     *
     * @param event the event
     * @return an instance of the specified package
     */
    P manufacture(E event);
}
