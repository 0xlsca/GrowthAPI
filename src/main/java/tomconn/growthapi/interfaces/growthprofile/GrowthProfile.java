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
public interface GrowthProfile< E extends Event, P extends GrowthProfile< E, P > > extends
        LightLevelMethods< P >,
        TemperatureMethods< P >,
        BiomeMethods< P >,
        SkyAffinityMethods< P > {

    /**
     * This method is expected to liquidate the growth-profile into a list of predicates which need to be met for the
     * respective growable to grow
     *
     * @return a list of predicates, based on this growth-profile
     *
     * @since 0.0.5
     */
    List< Predicate< E > > liquidate();

}
