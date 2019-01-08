package tomconn.growthapi.implementations.event.helpers;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;

/**
 * Defines basic methods which can be supported by both events (
 * {@link BlockEvent.CropGrowEvent.Pre} and
 * {@link SaplingGrowTreeEvent} )
 *
 * @since 0.0.5
 */
public abstract class PrimitiveEventHelper< E extends Event > implements BaseEventHelper {

    protected E event;


    /**
     * Default constructor
     *
     * @param event an instance of the event for which this helper was specialized
     *
     * @since 0.0.5
     */
    public PrimitiveEventHelper(E event) {
        this.event = event;
    }

}
