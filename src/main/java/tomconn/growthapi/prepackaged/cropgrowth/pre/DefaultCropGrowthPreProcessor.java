package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.parcel.IEventParcelFactory;
import tomconn.growthapi.prepackaged.DefaultEventFutureLogicUnits;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowthEventProcessor;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowthRequirementParcel;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DefaultCropGrowthPreProcessor<P extends ICropGrowthRequirementParcel<Pre>> implements ICropGrowthEventProcessor<Pre, P> {

    private final Map<Class<? extends Block>, List<Predicate<P>>> classPredicateMap = new HashMap<>();
    private final Set<Class<? extends Block>> classSet = classPredicateMap.keySet();
    private final IEventParcelFactory<Pre, P> packageFactory;
    private Consumer<EventFutureAssessment> resultingAssessmentConsumer = (e) -> {
    };

    public DefaultCropGrowthPreProcessor(IEventParcelFactory<Pre, P> packageFactory) {
        this.packageFactory = packageFactory;
    }

    @Override
    public EventFutureAssessment giveAssessmentOnEvent(P parcel) {
        if (classSet.contains(parcel.getBlockClass())) {
            return ICropGrowthEventProcessor.predicatesMet(
                    parcel,
                    classPredicateMap.get(parcel.getBlockClass()),
                    DefaultEventFutureLogicUnits.LOGIC_AND_DENY,
                    EventFutureAssessment.ALLOW,
                    EventFutureAssessment.DENY
            );
        }
        return EventFutureAssessment.DEFAULT;
    }

    @Override
    public Consumer<EventFutureAssessment> getResultingAssessmentConsumer() {
        return resultingAssessmentConsumer;
    }

    @Override
    public boolean setResultingAssessmentConsumer(Consumer<EventFutureAssessment> consumer) {
        this.resultingAssessmentConsumer = consumer;
        return true;
    }

    @Override
    public boolean canProcess(Class<? extends Event> eventclass) {
        return eventclass == Pre.class;
    }

    @Override
    public boolean isEligible(P parcel) {
        return classSet.contains(parcel.getBlockClass());
    }

    @Override
    public IEventParcelFactory<Pre, P> getPackageFactory() {
        return packageFactory;
    }

    @SafeVarargs
    @Override
    public final boolean registerCrop(Class<? extends Block> cropClass, Predicate<P>... requirements) {
        if (this.hasCropRegistered(cropClass)) {
            return false;
        } else return classPredicateMap.put(cropClass, Arrays.asList(requirements)) == null;
    }

    @Override
    public boolean unregisterCrop(Class<? extends Block> cropClass) {
        if (this.hasCropRegistered(cropClass)) {
            classPredicateMap.remove(cropClass);
            return true;
        }
        return false;
    }

    @Override
    public List<Class<? extends Block>> getRegisteredBlockClasses() {
        return new ArrayList<>(classSet);
    }
}
