package tomconn.growthapi.implementations.growthprofile.probability.profile;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Default {@link AbstractProbabilityGrowthProfile} implementation for {@link Pre}
 *
 * @since 0.0.6
 */
class CropProbabilityProfile extends AbstractProbabilityGrowthProfile< Pre > {

    private final Random random = new Random();


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    protected Random getRandomFromEvent(Pre event) {

        return random;
    }

}
