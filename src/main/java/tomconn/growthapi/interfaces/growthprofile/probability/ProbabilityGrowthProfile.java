package tomconn.growthapi.interfaces.growthprofile.probability;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

/**
 * A probability-based extension of {@link GrowthProfile}.
 *
 * @param <E> Any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface ProbabilityGrowthProfile< E extends Event > extends GrowthProfile< E > {

}
