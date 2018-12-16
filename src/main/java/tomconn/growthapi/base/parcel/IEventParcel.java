package tomconn.growthapi.base.parcel;

import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Provides methods for retrieving event-related data
 */
public interface IEventParcel<E extends Event> {

    /**
     * @return The class of the event with which this parcel is associated with
     */
    Class<E> getEventClass();
}
