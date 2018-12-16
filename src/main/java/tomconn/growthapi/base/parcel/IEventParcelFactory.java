package tomconn.growthapi.base.parcel;

import net.minecraftforge.fml.common.eventhandler.Event;

@FunctionalInterface
public interface IEventParcelFactory<E extends Event, P extends IEventParcel<E>> {

    /**
     * Manufactures a package based on the event
     *
     * @param event the event
     * @return an instance of the specified package
     */
    P manufacture(E event);
}
