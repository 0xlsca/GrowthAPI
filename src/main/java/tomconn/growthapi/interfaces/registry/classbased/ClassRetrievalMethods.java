package tomconn.growthapi.interfaces.registry.classbased;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This interface covers all retrieval methods of a {@link ClassBasedRegistry}.
 *
 * @since 0.0.5
 */
public interface ClassRetrievalMethods {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     *
     * @return an {@link Optional} collection of predicates which are registered with the block class for the {@link
     * CropGrowEvent.Pre} event
     *
     * @since 0.0.5
     */
    Optional< Collection< ? extends Predicate< Pre > > > getRequirementsForCropPre(Class< ? extends Block > blockClass);


    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     *
     * @return an {@link Optional} collection of predicates which are registered with the block class for the {@link
     * SaplingGrowTreeEvent}
     *
     * @since 0.0.5
     */
    Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > getRequirementsForSapling(Class< ? extends Block > blockClass);


    /**
     * Returns the currently registered consumer for the passed class.
     *
     * @param blockClass the class of the crop
     *
     * @return the consumer which was registered with the block class for the {@link Post} event
     *
     * @since 0.0.5
     */
    Optional< Consumer< Post > > getConsumerForCropPost(Class< ? extends Block > blockClass);

}
