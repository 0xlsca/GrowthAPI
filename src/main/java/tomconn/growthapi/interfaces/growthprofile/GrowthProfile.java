package tomconn.growthapi.interfaces.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;

import java.util.List;

/**
 * A growth-profile is based on an event and yields {@link GrowthCondition GrowthConditions} which take a respective event-instance and tell whether
 * or not the event shall pass
 *
 * @param <E> any inheritor of {@link Event}
 */
public interface GrowthProfile< E extends Event > {

    /**
     * This method is expected to liquidate the growth-profile into a list of {@link GrowthCondition GrowthConditions} which need to be met for the
     * respective growable to grow
     *
     * @return a list of {@link GrowthCondition GrowthConditions}, based on this growth-profile
     *
     * @since 0.0.5
     */
    List< GrowthCondition< E > > liquidate();

}
