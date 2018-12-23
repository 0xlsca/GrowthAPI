package tomconn.growthapi.interfaces.registry.profilebased.pre;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;

import java.util.List;
import java.util.function.Predicate;

/**
 * IPBR is the abbreviation for {@link tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry}
 */
public interface IPBRPreRetrievalMethods {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link Pre} event
     */
    List<Predicate<Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass);
}
