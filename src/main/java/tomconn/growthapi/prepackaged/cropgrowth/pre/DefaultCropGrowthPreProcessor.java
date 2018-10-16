package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.IEventPackageFactory;
import tomconn.growthapi.prepackaged.DefaultEventFutureDecisionMakers;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowthEventProcessor;
import tomconn.growthapi.prepackaged.cropgrowth.IGrowthRequirementParcel;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DefaultCropGrowthPreProcessor<P extends IGrowthRequirementParcel<Pre>> implements ICropGrowthEventProcessor<Pre, P> {

    private final Map<Class<? extends Block>, List<Predicate<P>>> classPredicateMap = new HashMap<>();
    private final Set<Class<? extends Block>> classSet = classPredicateMap.keySet();
    private final IEventPackageFactory<Pre, P> packageFactory;
    private Consumer<EventFutureAssessment> resultingAssessmentConsumer = (e) -> {
    };

    public DefaultCropGrowthPreProcessor(IEventPackageFactory<Pre, P> packageFactory) {
        this.packageFactory = packageFactory;
    }

    @Override
    public EventFutureAssessment giveAssessmentOnEvent(P parcel) {
        if (classSet.contains(parcel.getBlockClass())) {
            return ICropGrowthEventProcessor.predicatesMet(
                    parcel,
                    classPredicateMap.get(parcel.getBlockClass()),
                    DefaultEventFutureDecisionMakers.LOGIC_AND_DENY,
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
    public boolean canProcess(Class<Pre> eventclass) {
        return eventclass == Pre.class;
    }

    @Override
    public boolean isEligible(P parcel) {
        return classSet.contains(parcel.getBlockClass());
    }

    @Override
    public IEventPackageFactory<Pre, P> getPackageFactory() {
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
