package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.sky;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

/**
 * Provides methods which rely on whether or not the block has a los to the sky.
 *
 * @since 0.0.6
 */
public interface SkyTupleProbabilityMethods< E extends Event > {

    /**
     * Returns a chance-function which returns either of the two parameters
     *
     * @param ifCanSee    this value is returned of the block has a los to the sky
     * @param ifCannotSee this one is returned if the block does not have a los to the sky
     *
     * @return either of the two passed values
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > skyChance(Probability ifCanSee, Probability ifCannotSee);

}
