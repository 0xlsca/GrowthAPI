package tomconn.growthapi.base.processor;

import net.minecraftforge.fml.common.eventhandler.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.parcel.IEventParcel;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("WeakerAccess")
abstract class ICompositeEventProcessorDefaultImplTest<E extends Event, P extends IEventParcel<E>> {

    ICompositeEventProcessor<E, P> processor;

    final Supplier<E> eventSupplier;
    final Supplier<P> packetSupplier;
    final Supplier<Class<E>> eventClassSupplier;

    protected ICompositeEventProcessorDefaultImplTest(Supplier<E> eventSupplier, Supplier<P> packetSupplier, Supplier<Class<E>> eventClassSupplier) {
        this.eventSupplier = eventSupplier;
        this.packetSupplier = packetSupplier;
        this.eventClassSupplier = eventClassSupplier;
    }


    abstract ICompositeEventProcessor<E, P> getInstance();

    @BeforeEach
    void setUp() {
        processor = getInstance();
    }

    @Test
    void giveAssessmentOnEvent() {
        assertTrue(() -> {
            EventFutureAssessment assessment = processor.giveAssessmentOnEvent(eventSupplier.get());
            return Arrays.stream(EventFutureAssessment.values()).anyMatch(ass -> ass == assessment);
        });
        assertNotNull(processor.giveAssessmentOnEvent(eventSupplier.get()));
    }

    @Test
    void consumeResultingAssessment() {
        assertFalse(processor.consumeResultingAssessment(null));

        assertNotNull(processor.getResultingAssessmentConsumer());
        assertTrue(processor.consumeResultingAssessment(EventFutureAssessment.ALLOW));
    }

    @SuppressWarnings("unchecked")
    @Test
    void isEligible() {
        assertTrue(processor.isEligible(eventSupplier.get()), "Processors should always be eligible for events they provide via supplier");
        assertTrue(processor.isEligible(packetSupplier.get()), "Processors should always be eligible for packets they provide via supplier");
    }

    @Test
    void processorForeignEvent() {
        assertFalse(processor.isEligible(new Event() {
        }), "Processors should not accept all events");
    }

    @Test
    void processorNullRobust() {
        assertFalse(processor.isEligible((E) null), "Processors should be null-value-parameter resistant");
    }

    public static class TestEvent extends Event {

    }

    public static class TestEventParcel implements IEventParcel<TestEvent> {

        private TestEvent event;

        public TestEventParcel(TestEvent testEvent) {
            event = testEvent;
        }

        public TestEventParcel() {

        }

        @Override
        public Class<TestEvent> getEventClass() {
            return TestEvent.class;
        }
    }
}