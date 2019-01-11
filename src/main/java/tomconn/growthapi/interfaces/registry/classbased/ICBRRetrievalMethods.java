package tomconn.growthapi.interfaces.registry.classbased;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import tomconn.growthapi.implementations.event.EventManager;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This interface covers all retrieval methods of an {@link IClassBasedRegistry}.
 * They are mainly called by {@link EventManager} whilst it decides whether or not a
 * event shall pass.
 */
public interface ICBRRetrievalMethods {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link CropGrowEvent.Pre} event
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
     * {@link CropGrowEvent.Post} event
     */
    Consumer<BlockEvent.CropGrowEvent.Post> getConsumerForCropPost(Class<? extends Block> blockClass);
}
