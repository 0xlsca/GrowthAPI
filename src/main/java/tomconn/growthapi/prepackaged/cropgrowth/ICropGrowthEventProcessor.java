package tomconn.growthapi.prepackaged.cropgrowth;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.ICompositeBlockBasedEventProcessor;
import tomconn.growthapi.base.IEventFutureDecisionMaker;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface ICropGrowthEventProcessor<E extends BlockEvent.CropGrowEvent, P extends IGrowthRequirementParcel<E>> extends ICompositeBlockBasedEventProcessor<E, P> {

    /**
     * tests the provided predicates with the provided parcel, transforming them into a respective list of
     * {@link EventFutureAssessment}s and makes a decision based on the provided decision-maker
     *
     * @param parcel        the parcel
     * @param predicates    the predicates
     * @param decisionmaker the decision-maker
     * @param positive      the {@link EventFutureAssessment} to choose in case the tested {@link Predicate} returns true
     * @param negative      the {@link EventFutureAssessment} to choose in case the tested {@link Predicate} returns false
     * @param <P>           any variation of {@link IGrowthRequirementParcel}
     * @param <D>           any variation of {@link IEventFutureDecisionMaker}
     * @return a {@link EventFutureAssessment} returned form the provided {@link IEventFutureDecisionMaker}
     */
    static <P extends IGrowthRequirementParcel,
            D extends IEventFutureDecisionMaker>
    EventFutureAssessment predicatesMet(
            P parcel,
            List<Predicate<P>> predicates,
            D decisionmaker,
            EventFutureAssessment positive,
            EventFutureAssessment negative
    ) {
        return decisionmaker.decide(
                predicates.stream()
                        .map(p -> p.test(parcel) ? positive : negative)
                        .collect(Collectors.toList())
        );
    }

    /**
     * Registers a crop in this processor with the respective growth requirements
     *
     * @param cropClass    the class of the crop
     * @param requirements the requirements as a {@link List} consisting of {@link Predicate}s
     * @return <ul>
     * <li>true if and only if the crop was successfully registered and will be considered in case a matching {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre}-event is fired </li>
     * <li>false otherwise</li>
     * </ul>
     */
    @SuppressWarnings("unchecked")
    boolean registerCrop(Class<? extends Block> cropClass, Predicate<P>... requirements);

    /**
     * Unregisters the provided class and its associated predicates in case it was present
     *
     * @param cropClass the class of the crop-block
     * @return <ul>
     * <li>
     * {@code true} if and only if there was a crop-class registered which was reference-equal with
     * the provided class and it was successfully removed from the processor's registry
     * </li>
     * <li>
     * {@code false} otherwise
     * </li>
     * </ul>
     */
    boolean unregisterCrop(Class<? extends Block> cropClass);


    /**
     * Checks whether the provided crop-block class is registered in this processor
     *
     * @param cropClass the class of the respective crop-block
     * @return <ul>
     * <li>
     * {@code true} if and only if there was a crop-class registered which was reference-equal with
     * the provided class
     * </li>
     * <li>
     * {@code false} otherwise
     * </li>
     * </ul>
     */
    default boolean hasCropRegistered(Class<? extends Block> cropClass) {
        return this.getRegisteredBlockClasses().stream()
                .anyMatch(c -> c == cropClass);
    }
}
