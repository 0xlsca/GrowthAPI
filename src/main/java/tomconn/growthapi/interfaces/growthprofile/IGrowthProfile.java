package tomconn.growthapi.interfaces.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;
import java.util.function.Predicate;

/**
 * This interface is meant to provide cross-event functionality in regards of the growth process of anything
 */
public interface IGrowthProfile<E extends Event> {

    /**
     * This method is expected to liquidate the growth-profile into a list of predicates which need to be met for the
     * respective growable to grow
     *
     * @return a list of predicates, based on this growth-profile
     */
    List<Predicate<E>> liquidate();
}
