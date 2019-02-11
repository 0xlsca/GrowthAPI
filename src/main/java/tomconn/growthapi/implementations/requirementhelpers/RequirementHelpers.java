package tomconn.growthapi.implementations.requirementhelpers;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import org.jetbrains.annotations.Contract;
import tomconn.growthapi.interfaces.requirementhelpers.BaseRequirementHelper;

import javax.annotation.Nonnull;

/**
 * This class provides static-level endpoints for obtaining {@link BaseRequirementHelper BaseRequirementHelpers}
 *
 * @since 0.0.6
 */
public interface RequirementHelpers {

    /**
     * Returns a new {@link BaseRequirementHelper} which is specialized for {@link Pre}
     *
     * @return a new {@link BaseRequirementHelper}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static BaseRequirementHelper< Pre > cropPre() {

        return new CropGrowPreRequirementHelper();
    }


    /**
     * Returns a new {@link BaseRequirementHelper} which is specialized for the {@link SaplingGrowTreeEvent}
     *
     * @return a new {@link BaseRequirementHelper}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static BaseRequirementHelper< SaplingGrowTreeEvent > sapling() {

        return new SaplingGrowTreeRequirementHelper();
    }

}
