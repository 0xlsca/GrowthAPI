package tomconn.growthapi.base.processor;

import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.ICompositeEventProcessor;
import tomconn.growthapi.base.IEventPackageFactory;

import java.util.function.Consumer;

public class ProcessorTest {
    public static class DefaultTest extends ICompositeEventProcessorDefaultImplTest implements ICompositeEventProcessor<ICompositeEventProcessorDefaultImplTest.TestEvent, ICompositeEventProcessorDefaultImplTest.TestEventParcel> {

        Consumer<EventFutureAssessment> eventFutureAssessmentConsumer = consumer -> {
        };

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
        public boolean canProcess(Class<TestEvent> eventclass) {
            return eventclass == TestEvent.class;
        }

        @Override
        public boolean isEligible(TestEventParcel parcel) {
            return parcel.getEventClass() == TestEvent.class;
        }

        @Override
        public IEventPackageFactory<TestEvent, TestEventParcel> getPackageFactory() {
            return TestEventParcel::new;
        }

        @Override
        ICompositeEventProcessor<TestEvent, ?> getInstance() {
            return new DefaultTest();
        }
    }

}
