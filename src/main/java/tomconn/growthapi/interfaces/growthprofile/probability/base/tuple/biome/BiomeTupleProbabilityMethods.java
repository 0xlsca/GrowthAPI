package tomconn.growthapi.interfaces.growthprofile.probability.base.tuple.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunctionTuple;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.SingleValueDomainContainer;

import java.util.Arrays;
import java.util.Collection;

/**
 * Tupled chance-functions for {@link Biome}s
 *
 * @since 0.0.6
 */
public interface BiomeTupleProbabilityMethods< E extends Event > {


    /**
     * Tailors a {@link ProbabilityFunction} based on the passed tuples
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}
     *
     * @since 0.0.6
     */
    default ProbabilityFunction< E > biomeTupledChance(ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome >, ? >... tuples) {

        return biomeTupledChance(Arrays.asList(tuples));
    }


    /**
     * Tailors a {@link ProbabilityFunction} based on the passed tuples
     *
     * @param tuples the tuples
     *
     * @return a respective {@link ProbabilityFunction}
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > biomeTupledChance(Collection< ProbabilityFunctionTuple< Biome, SingleValueDomainContainer< Biome >, ? > > tuples);

}
