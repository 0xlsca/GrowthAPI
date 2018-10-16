package tomconn.growthapi.base.processor;

import net.minecraftforge.fml.common.eventhandler.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.ICompositeEventProcessor;
import tomconn.growthapi.base.IEventPackage;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("WeakerAccess")
abstract class ICompositeEventProcessorDefaultImplTest {

    ICompositeEventProcessor<TestEvent, ?> processor;

    abstract ICompositeEventProcessor<TestEvent, ?> getInstance();

    @BeforeEach
    void setUp() {
        processor = getInstance();
    }

    @Test
    void giveAssessmentOnEvent() {
        assertTrue(() -> {
            EventFutureAssessment assessment = processor.giveAssessmentOnEvent(new TestEvent());
            return Arrays.stream(EventFutureAssessment.values()).anyMatch(ass -> ass == assessment);
        });
        assertNotNull(processor.giveAssessmentOnEvent(new TestEvent()));
    }

    @Test
    void consumeResultingAssessment() {
        assertFalse(processor.consumeResultingAssessment(null));

        assertNotNull(processor.getResultingAssessmentConsumer());
        assertTrue(processor.consumeResultingAssessment(EventFutureAssessment.ALLOW));
    }

    @Test
    void isEligible() {
        assertTrue(processor.isEligible(new TestEvent()));
        assertFalse(processor.isEligible((TestEvent) null));
    }

    public static class TestEvent extends Event {

    }

    public static class TestEventParcel implements IEventPackage<TestEvent> {

        private TestEvent event;

        public TestEventParcel(TestEvent testEvent) {
            event = testEvent;
        }

        @Override
        public Class<TestEvent> getEventClass() {
            return TestEvent.class;
        }
    }
}