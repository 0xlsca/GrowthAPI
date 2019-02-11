package tomconn.growthapi.implementations.growthprofile.probability.function_helpers.tuple;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import org.jetbrains.annotations.Contract;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.TupleProbabilityFunctionHelper;

import javax.annotation.Nonnull;

/**
 * This interface provides static-level endpoints for instantiating {@link TupleProbabilityFunctionHelper
 * TupleProbabilityFunctionHelpers}
 *
 * @since 0.0.6
 */
public interface TupleHelpers {

    /**
     * Instantiates a new {@link TupleProbabilityFunctionHelper} which is specialized for {@link Pre}.
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static TupleProbabilityFunctionHelper< Pre > cropHelper() {

        return new CropTupleProbabilityHelper();
    }


    /**
     * Instantiates a new {@link TupleProbabilityFunctionHelper} which is specialized for {@link SaplingGrowTreeEvent}.
     *
     * @return a new instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract(" -> new")
    static TupleProbabilityFunctionHelper< SaplingGrowTreeEvent > saplingHelper() {

        return new SaplingTupleProbabilityHelper();
    }

}
