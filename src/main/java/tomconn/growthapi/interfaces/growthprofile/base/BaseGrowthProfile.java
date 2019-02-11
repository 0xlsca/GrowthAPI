package tomconn.growthapi.interfaces.growthprofile.base;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.base.methods.BiomeMethods;
import tomconn.growthapi.interfaces.growthprofile.base.methods.LightLevelMethods;
import tomconn.growthapi.interfaces.growthprofile.base.methods.SkyAffinityMethods;
import tomconn.growthapi.interfaces.growthprofile.base.methods.TemperatureMethods;

/**
 * This interface is meant to provide cross-event functionality in regards of the growth process of anything
 *
 * @since 0.0.6
 */
public interface BaseGrowthProfile< E extends Event, P extends BaseGrowthProfile< E, P > > extends
        GrowthProfile< E >,
        LightLevelMethods< P >,
        TemperatureMethods< P >,
        BiomeMethods< P >,
        SkyAffinityMethods< P > {


}
