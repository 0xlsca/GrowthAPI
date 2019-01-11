package tomconn.growthapi.implementations.growthprofile;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.requirementhelpers.crop.CropGrowPreRequirementHelper;

import javax.annotation.Nonnull;

/**
 * This profile covers all growth related things for crops.
 * It was designed with the option to be extendable.
 * <p>
 * This class incorporates chaining methods, which allow for eased building of distinct profiles.
 *
 * @since 0.0.5
 */
class CropGrowthProfile extends AbstractGrowthProfile< Pre, CropGrowthProfile > {

    /**
     * Default constructor
     *
     * @since 0.0.5
     */
    CropGrowthProfile() {
        super(new CropGrowPreRequirementHelper());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    public CropGrowthProfile getThis() {

        return this;
    }

}
