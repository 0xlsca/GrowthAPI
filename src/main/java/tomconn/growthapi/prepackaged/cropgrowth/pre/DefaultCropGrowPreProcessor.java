package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.decision_logic_unit.ILocalEventFutureDecisionUnit;
import tomconn.growthapi.base.parcel.IEventParcelFactory;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowEventProcessor;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment.DEFAULT;

public class DefaultCropGrowPreProcessor implements ICropGrowEventProcessor<BlockEvent.CropGrowEvent.Pre, DefaultCropGrowPreParcel> {

    Map<Class<? extends Block>, Tuple<Predicate<DefaultCropGrowPreParcel>[], ILocalEventFutureDecisionUnit>> cropMap = new HashMap<>();

    private Consumer<EventFutureAssessment> resultingAssessmentConsumer;

    @Override
    public boolean registerCrop(Class<? extends Block> cropClass, ILocalEventFutureDecisionUnit decisionUnit, Predicate<DefaultCropGrowPreParcel>... predicates) {
        return cropMap.put(cropClass, new Tuple<>(predicates, decisionUnit)) == null;
    }

    @Override
    public boolean unregisterCrop(Class<? extends Block> cropClass) {
        return cropMap.remove(cropClass) != null;
    }

    @Override
    public List<Class<? extends Block>> getRegisteredBlockClasses() {
        return Collections.unmodifiableList(new ArrayList<>(cropMap.keySet()));
    }

    @Override
    public EventFutureAssessment giveAssessmentOnEvent(DefaultCropGrowPreParcel parcel) {
        if (isEligible(parcel)) {
            return giveAssessment(parcel);
        } else {
            return DEFAULT;
        }
    }

    @Override
    public boolean setResultingAssessmentConsumer(Consumer<EventFutureAssessment> consumer) {
        resultingAssessmentConsumer = consumer;
        return true;
    }

    @Override
    public boolean canProcess(Class<? extends Event> eventclass) {
        return eventclass == BlockEvent.CropGrowEvent.Pre.class;
    }

    @Override
    public boolean isEligible(DefaultCropGrowPreParcel parcel) {
        return cropMap.keySet().contains(parcel.getBlockClass());
    }

    @Override
    public IEventParcelFactory<BlockEvent.CropGrowEvent.Pre, DefaultCropGrowPreParcel> getPackageFactory() {
        return DefaultCropGrowPreParcel::new;
    }

    private ILocalEventFutureDecisionUnit retrieveDecisionUnit(DefaultCropGrowPreParcel parcel) {
        return cropMap.get(parcel.getBlockClass()).getSecond();
    }

    private Predicate<DefaultCropGrowPreParcel>[] retrieveRequirements(Class<? extends Block> blockClass) {
        return cropMap.get(blockClass).getFirst();
    }

    private EventFutureAssessment giveAssessment(DefaultCropGrowPreParcel parcel) {
        ILocalEventFutureDecisionUnit decisionUnit = retrieveDecisionUnit(parcel);
        return decisionUnit.decide(
                Arrays.stream(retrieveRequirements(parcel.getBlockClass()))
                        .map(pred -> pred.test(parcel))
                        .collect(Collectors.toList())

        );
    }
}
