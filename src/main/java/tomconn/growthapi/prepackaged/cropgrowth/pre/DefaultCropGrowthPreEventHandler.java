package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.base.ICompositeBlockBasedEventProcessor;
import tomconn.growthapi.base.IEventFutureDecisionMaker;
import tomconn.growthapi.base.IEventHandler;
import tomconn.growthapi.prepackaged.DefaultEventFutureDecisionMakers;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DefaultCropGrowthPreEventHandler implements IEventHandler<Pre, ICompositeBlockBasedEventProcessor<Pre, ?>> {

    private IEventFutureDecisionMaker decisionMaker = DefaultEventFutureDecisionMakers.LOGIC_OR_DENY;
    private List<ICompositeBlockBasedEventProcessor<Pre, ?>> processors = new ArrayList<>();

    @Override
    public boolean canHandle(@Nonnull Class eventclass) {
        return eventclass == Pre.class;
    }


    @Override
    public List<ICompositeBlockBasedEventProcessor<Pre, ?>> getProcessors() {
        return Collections.unmodifiableList(this.processors);
    }

    @Override
    public boolean setEventFutureDecisionMaker(@Nonnull IEventFutureDecisionMaker decisionMaker) {
        this.decisionMaker = decisionMaker;
        return true;
    }

    @Override
    public IEventFutureDecisionMaker getEventFutureDecisionMaker() {
        return this.decisionMaker;
    }

    @Override
    public boolean registerProcessor(@Nonnull ICompositeBlockBasedEventProcessor<Pre, ?> processor) {
        return this.processors.add(processor);
    }

    @Override
    public boolean removeProcessor(@Nonnull ICompositeBlockBasedEventProcessor<Pre, ?> processor) {
        return processors.remove(processor);
    }

    @Override
    public boolean hasProcessor(@Nonnull ICompositeBlockBasedEventProcessor<Pre, ?> processor) {
        return processors.contains(processor);
    }
}
