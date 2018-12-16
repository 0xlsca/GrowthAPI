package tomconn.growthapi.base.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.decision_logic_unit.ILocalEventFutureDecisionUnit;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowRequirementParcel;
import tomconn.growthapi.prepackaged.decision_logic_unit.DefaultLocalDecisionLogicUnits;

import java.util.List;
import java.util.function.Predicate;

public interface ICropGrowthRegistry {

    ILocalEventFutureDecisionUnit DEFAULT_AND = DefaultLocalDecisionLogicUnits.LOGIC_AND_DENY;
    ILocalEventFutureDecisionUnit DEFAULT_OR = DefaultLocalDecisionLogicUnits.LOGIC_OR_DENY;

    /**
     * Purpose of this method is to register a block class with the respective predicates and
     * a decision maker
     *
     * @param cropClass    the class of the growing entity
     * @param predicates   the predicates
     * @param decisionUnit the decision maker
     * @param eventClass
     * @return true if and only if the class was registered successfully, false otherwise
     */
    <E extends BlockEvent.CropGrowEvent> boolean registerCrop(
            Class<Block> cropClass,
            List<Predicate<ICropGrowRequirementParcel<E>>> predicates,
            ILocalEventFutureDecisionUnit decisionUnit, Class<E> eventClass);


    default <E extends BlockEvent.CropGrowEvent> boolean registerCropAND(
            Class<Block> cropClass,
            List<Predicate<ICropGrowRequirementParcel<E>>> predicates,
            ILocalEventFutureDecisionUnit decisionUnit,
            Class<E> eventClass
    ) {
        return registerCrop(cropClass, predicates, this.DEFAULT_AND, eventClass);
    }

    default <E extends BlockEvent.CropGrowEvent> boolean registerCropOR(
            Class<Block> cropClass,
            List<Predicate<ICropGrowRequirementParcel<E>>> predicates,
            ILocalEventFutureDecisionUnit decisionUnit,
            Class<E> eventClass
    ) {
        return registerCrop(cropClass, predicates, this.DEFAULT_OR, eventClass);
    }

}
