package tomconn.growthapi.interfaces.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.base.BiomeMethods;
import tomconn.growthapi.interfaces.growthprofile.base.LightLevelMethods;
import tomconn.growthapi.interfaces.growthprofile.base.SkyAffinityMethods;
import tomconn.growthapi.interfaces.growthprofile.base.TemperatureMethods;

import java.util.List;
import java.util.function.Predicate;

/**
 * This interface is meant to provide cross-event functionality in regards of the growth process of anything
 *
 * @since 0.0.5
 */
public interface BaseGrowthProfile< E extends Event, P extends BaseGrowthProfile< E, P > > extends
        GrowthProfile<E>,
        LightLevelMethods< P >,
        TemperatureMethods< P >,
        BiomeMethods< P >,
        SkyAffinityMethods< P > {



}
