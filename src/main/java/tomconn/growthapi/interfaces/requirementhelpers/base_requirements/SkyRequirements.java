package tomconn.growthapi.interfaces.requirementhelpers.base_requirements;


import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;

/**
 * Provides methods which relay {@link World#canBlockSeeSky(BlockPos)}
 *
 * @param <E>
 *
 * @since 0.0.6
 */
public interface SkyRequirements< E extends Event > extends BaseRequirement< E > {

    /**
     * Returns a {@link GrowthCondition} which ensures that a block only grows if it <b><u>does not have</u></b>a clear
     * line of sight to the sky
     *
     * @return a negated {@link World#canSeeSky(BlockPos)}-based {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > mustntSeeSky() {

        return mustSeeSky().negate();
    }


    /**
     * Returns a {@link GrowthCondition} which ensures that a block only grows if it has a clear line of sight to the
     * sky
     *
     * @return a {@link World#canSeeSky(BlockPos)}-based {@link GrowthCondition}
     *
     * @since 0.0.6
     */
    default GrowthCondition< E > mustSeeSky() {

        return e -> supplyHelper(e).canSeeSky();
    }

}
