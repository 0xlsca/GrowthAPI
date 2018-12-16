package tomconn.growthapi.prepackaged;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.decision_logic_unit.ILocalEventFutureDecisionUnit;
import tomconn.growthapi.base.registry.IGrowthRegistry;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowRequirementParcel;

import java.util.List;
import java.util.function.Predicate;

/**
 * This class is a singleton. <br>
 * It is supposed to represent the default implementation of {@link IGrowthRegistry}
 */
public class DefaultGrowthRegistry implements IGrowthRegistry {

    @Override
    public <E extends BlockEvent.CropGrowEvent>
    boolean registerCrop(
            Class<Block> cropClass,
            List<Predicate<ICropGrowRequirementParcel<E>>> predicates,
            ILocalEventFutureDecisionUnit decisionUnit,
            Class<E> eventClass
    ) {

    }
}
