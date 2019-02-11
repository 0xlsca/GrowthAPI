package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.interval;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import org.jetbrains.annotations.Contract;
import tomconn.growthapi.interfaces.growthprofile.probability.base.interval.IntervalProbabilityFunctionHelper;

import javax.annotation.Nonnull;

/**
 * This interface provides static-level endpoints for instantiating {@link IntervalProbabilityFunctionHelper
 * IntervalProbabilityFunctionHelpers}
 *
 * @since 0.0.6
 */
public interface IntervalHelpers {

    /**
     * Instantiates a new instance of {@link IntervalProbabilityFunctionHelper} which is specialized for {@link Pre}.
     *
     * @return a new instance
     */
    @Nonnull
    @Contract(" -> new")
    static IntervalProbabilityFunctionHelper< Pre > cropHelper() {

        return new CropIntervalProbabilityFunctionHelper();
    }


    /**
     * Instantiates a new instance of {@link IntervalProbabilityFunctionHelper} which is specialized for {@link
     * SaplingGrowTreeEvent}.
     *
     * @return a new instance
     */
    @Nonnull
    @Contract(" -> new")
    static IntervalProbabilityFunctionHelper< SaplingGrowTreeEvent > saplingHelper() {

        return new SaplingIntervalProbabilityHelper();
    }

}
