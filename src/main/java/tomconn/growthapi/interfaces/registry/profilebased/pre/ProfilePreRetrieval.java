package tomconn.growthapi.interfaces.registry.profilebased.pre;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * todo
 *
 * @since 0.0.5
 */
public interface ProfilePreRetrieval {

    /**
     * todo
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link Pre} event
     *
     * @since 0.0.5
     */
    Optional< Collection< ? extends Predicate< Pre > > > getRequirementsForCropPre(Class< ? extends Block > blockClass);
}
