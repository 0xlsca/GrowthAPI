package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.decision_logic_unit.IEventFutureDecisionLogicUnit;
import tomconn.growthapi.base.handler.IEventHandler;
import tomconn.growthapi.prepackaged.decision_logic_unit.DefaultEventFutureLogicUnits;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is a singleton. <br>
 * It also represents the default implementation for handling {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre}
 * events.
 */
public class DefaultCropGrowPreEventHandler implements IEventHandler<BlockEvent.CropGrowEvent.Pre, DefaultCropGrowPreProcessor> {

    private static DefaultCropGrowPreEventHandler instance = new DefaultCropGrowPreEventHandler();

    private DefaultCropGrowPreEventHandler() {
    }

    public static DefaultCropGrowPreEventHandler getInstance() {
        return instance;
    }

    private List<DefaultCropGrowPreProcessor> preProcessors = new ArrayList<>();
    private IEventFutureDecisionLogicUnit decisionLogicUnit = DefaultEventFutureLogicUnits.LOGIC_AND_DENY;

    @Override
    public boolean canHandle(@Nonnull Class<BlockEvent.CropGrowEvent.Pre> eventclass) {
        return eventclass == BlockEvent.CropGrowEvent.Pre.class;
    }

    @Override
    public boolean registerProcessor(@Nonnull DefaultCropGrowPreProcessor processor) {
        return preProcessors.add(processor);
    }

    @Override
    public boolean removeProcessor(@Nonnull DefaultCropGrowPreProcessor processor) {
        return preProcessors.remove(processor);
    }

    @Override
    public boolean hasProcessor(@Nonnull DefaultCropGrowPreProcessor processor) {
        return preProcessors.contains(processor);
    }

    @Override
    public List<DefaultCropGrowPreProcessor> getProcessors() {
        return Collections.unmodifiableList(this.preProcessors);
    }

    @Override
    public boolean setEventFutureDecisionLogicUnit(@Nonnull IEventFutureDecisionLogicUnit decisionMaker) {
        this.decisionLogicUnit = decisionMaker;
        return true;
    }

    @Override
    public IEventFutureDecisionLogicUnit getEventFutureDecisionLogicUnit() {
        return this.decisionLogicUnit;
    }
}
