package tomconn.growthapi.base.processor;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.parcel.IEventParcelFactory;

import java.util.function.Consumer;

import static tomconn.growthapi.TestUtils.*;

public class ProcessorTest {
    public static class DefaultTest
            extends
            ICompositeEventProcessorDefaultImplTest<
                    ICompositeEventProcessorDefaultImplTest.TestEvent,
                    ICompositeEventProcessorDefaultImplTest.TestEventParcel
                    >
            implements
            ICompositeEventProcessor<
                    ICompositeEventProcessorDefaultImplTest.TestEvent,
                    ICompositeEventProcessorDefaultImplTest.TestEventParcel
                    > {

        Consumer<EventFutureAssessment> eventFutureAssessmentConsumer = consumer -> {
        };


        public DefaultTest() {
            super(
                    TestEvent::new,
                    TestEventParcel::new,
                    () -> TestEvent.class
            );
        }

        @Override
        public EventFutureAssessment giveAssessmentOnEvent(TestEventParcel parcel) {
            return EventFutureAssessment.ALLOW;
        }

        @Override
        public Consumer<EventFutureAssessment> getResultingAssessmentConsumer() {
            return eventFutureAssessmentConsumer;
        }

        @Override
        public boolean setResultingAssessmentConsumer(Consumer<EventFutureAssessment> consumer) {
            this.eventFutureAssessmentConsumer = consumer;
            return true;
        }

        @Override
        public boolean canProcess(Class<? extends Event> eventclass) {
            return eventclass == TestEvent.class;
        }

        @Override
        public boolean isEligible(TestEventParcel parcel) {
            return parcel.getEventClass() == TestEvent.class;
        }

        @Override
        public IEventParcelFactory<TestEvent, TestEventParcel> getPackageFactory() {
            return TestEventParcel::new;
        }

        @Override
        ICompositeEventProcessor<TestEvent, TestEventParcel> getInstance() {
            return new DefaultTest();
        }
    }

    public static class DefaultGrowthPreProcessorTest
            extends
            ICompositeEventProcessorDefaultImplTest<BlockEvent.CropGrowEvent.Pre, DefaultCropCropGrowthPreEventParcel> {

        public DefaultGrowthPreProcessorTest() {
            super(
                    () -> new BlockEvent.CropGrowEvent.Pre(WORLD, BLOCK_POS, BLOCK_STATE),
                    () -> new DefaultCropCropGrowthPreEventParcel(new BlockEvent.CropGrowEvent.Pre(WORLD, BLOCK_POS, BLOCK_STATE)),
                    () -> BlockEvent.CropGrowEvent.Pre.class

            );
        }

        @Override
        ICompositeEventProcessor<BlockEvent.CropGrowEvent.Pre, DefaultCropCropGrowthPreEventParcel> getInstance() {
            return new DefaultCropGrowthPreProcessor<>(DefaultCropCropGrowthPreEventParcel::new);
        }
    }

}
