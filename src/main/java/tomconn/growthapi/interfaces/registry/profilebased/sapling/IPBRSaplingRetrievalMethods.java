package tomconn.growthapi.interfaces.registry.profilebased.sapling;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

import java.util.List;
import java.util.function.Predicate;

public interface IPBRSaplingRetrievalMethods {

    /**
     * Returns the currently registered requirements for the passed class.
     *
     * @param blockClass the class of the crop
     * @return an array of predicates which are registered with the block class for the
     * {@link SaplingGrowTreeEvent}
     */
    List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass);

}
