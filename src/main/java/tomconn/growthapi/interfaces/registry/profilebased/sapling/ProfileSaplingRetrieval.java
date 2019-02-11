package tomconn.growthapi.interfaces.registry.profilebased.sapling;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * todo
 *
 * @since 0.0.5
 */
public interface ProfileSaplingRetrieval {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link SaplingGrowTreeEvent}
     * @since 0.0.5
     */
    Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > getRequirementsForSapling(Class< ? extends Block > blockClass);

}
