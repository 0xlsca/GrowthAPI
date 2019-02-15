package tomconn.growthapi.implementations.event.helper;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.event.helper.BaseEventHelper;

/**
 * Skeleton class of {@link BaseEventHelper}
 *
 * @since 0.0.5
 */
abstract class AbstractBaseEventHelper< E extends Event > implements BaseEventHelper {

    protected E event;


    /**
     * Default constructor
     *
     * @param event an instance of the event for which this helper was specialized
     *
     * @since 0.0.5
     */
    public AbstractBaseEventHelper(E event) {
        this.event = event;
    }

}
