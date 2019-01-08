package tomconn.growthapi.interfaces.event.helpers;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.event.helpers.base_information.*;

/**
 * A <code>BaseEventHelper</code> helps with retrieving basic information from any {@link Event}.
 *
 * @since 0.0.6
 */
public interface BaseEventHelper extends
        BiomeProvider,
        BlockClassProvider,
        BlockPosProvider,
        CanSeeSkyProvider,
        LightLevelProvider,
        TemperatureProvider,
        WorldProvider {

}
