package tomconn.growthapi.implementations.growthprofile.probability.profile;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Default {@link AbstractProbabilityGrowthProfile} implementation for {@link SaplingGrowTreeEvent}
 *
 * @since 0.0.6
 */
class SaplingProbabilityProfile extends AbstractProbabilityGrowthProfile< SaplingGrowTreeEvent > {

    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    protected Random getRandomFromEvent(SaplingGrowTreeEvent event) {

        return event.getRand();
    }

}
