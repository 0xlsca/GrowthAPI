package tomconn.growthapi.interfaces.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;
import java.util.function.Predicate;

/**
 * A growth-profile is based on an event and yields predicates which take a respective event-instance and tell whether
 * or not the event shall pass
 *
 * @param <E> any inheritor of {@link Event}
 */
public interface GrowthProfile< E extends Event > {

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
