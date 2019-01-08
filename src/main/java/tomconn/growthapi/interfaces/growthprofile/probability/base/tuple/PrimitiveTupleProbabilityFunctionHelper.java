package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple;

import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.biome.BiomeTupleProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.blockpos.BlockPosTupleProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.lightlevel.LightLevelTupleProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.sky.SkyTupleProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.temperature.TemperatureTupleProbabilityMethods;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

/**
 * Unifies all {@link Tuple}-based
 * {@link ProbabilityFunction}-interfaces
 *
 * @since 0.0.6
 */
public interface PrimitiveTupleProbabilityFunctionHelper< E extends Event > extends
        BlockPosTupleProbabilityMethods< E >,
        LightLevelTupleProbabilityMethods< E >,
        TemperatureTupleProbabilityMethods< E >,
        BiomeTupleProbabilityMethods< E >,
        SkyTupleProbabilityMethods< E > {

}
