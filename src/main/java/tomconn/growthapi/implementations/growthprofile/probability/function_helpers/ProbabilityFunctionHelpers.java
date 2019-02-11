package tomconn.growthapi.implementations.growthprofile.probability.function_helpers;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import org.jetbrains.annotations.Contract;
import tomconn.growthapi.interfaces.growthprofile.probability.base.ProbabilityFunctionHelper;

import javax.annotation.Nonnull;

/**
 * This interface provides static-level endpoints for instantiating {@link AbstractProbabilityFunctionHelper}s
 *
 * @since 0.0.6
 */
public interface ProbabilityFunctionHelpers {

    /**
     * Returns a new instance of {@link ProbabilityFunctionHelper} for the {@link Pre} event
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static ProbabilityFunctionHelper< Pre > cropHelper() {

        return new CropProbabilityFunctionHelper();
    }


    /**
     * Returns a new instance of {@link ProbabilityFunctionHelper} for the {@link Pre} event
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static ProbabilityFunctionHelper< SaplingGrowTreeEvent > saplingHelper() {

        return new SaplingProbabilityFunctionHelper();
    }

}
