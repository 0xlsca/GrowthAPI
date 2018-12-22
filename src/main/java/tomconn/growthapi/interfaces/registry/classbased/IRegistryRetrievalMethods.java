package tomconn.growthapi.interfaces.registry.classbased;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This interface covers all retrieval methods of an {@link IRegistry}.
 * They are mainly called by {@link tomconn.growthapi.implementations.EventManager} whilst it decides whether or not a
 * event shall pass.
 */
public interface IRegistryRetrievalMethods {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} event
     */
    List<Predicate<BlockEvent.CropGrowEvent.Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass);

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link SaplingGrowTreeEvent}
     */
    List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass);

    /**
     * Returns the currently registered consumer for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} event
     */
    Consumer<BlockEvent.CropGrowEvent.Post> getConsumerForCropPost(Class<? extends Block> blockClass);
}
