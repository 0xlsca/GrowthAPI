package tomconn.growthapi.prepackaged;

import net.minecraft.util.Tuple;
import org.junit.jupiter.api.Test;
import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.IEventFutureDecisionMaker;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tomconn.growthapi.base.EventFutureAssessment.*;

@SuppressWarnings("WeakerAccess")
class DefaultEventFutureDecisionMakersTest {

    static List<EventFutureAssessment> MIXED_ASSESSMENTS = Arrays.asList(
            ALLOW,
            ALLOW,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT
    );

    static List<EventFutureAssessment> ALL_ALLOW = Arrays.asList(
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW
    );

    static List<EventFutureAssessment> ALL_DENY = Arrays.asList(
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY,
            EventFutureAssessment.DENY
    );

    static List<EventFutureAssessment> ALL_DEFAULT = Arrays.asList(
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT,
            EventFutureAssessment.DEFAULT
    );

    static List<EventFutureAssessment> SINGLE_ALLOW_REST_DENY = Arrays.asList(
            ALLOW,
            DENY,
            DENY,
            DENY,
            DENY,
            DENY
    );

    static List<EventFutureAssessment> SINGLE_ALLOW_REST_DEFAULT = Arrays.asList(
            ALLOW,
            DEFAULT,
            DEFAULT,
            DEFAULT,
            DEFAULT,
            DEFAULT
    );

    static List<EventFutureAssessment> SINGLE_DENY_REST_ALLOW = Arrays.asList(
            DENY,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW
    );

    static List<EventFutureAssessment> SINGLE_DENY_REST_DEFAULT = Arrays.asList(
            DENY,
            DEFAULT,
            DEFAULT,
            DEFAULT,
            DEFAULT,
            DEFAULT
    );

    static List<EventFutureAssessment> SINGLE_DEFAULT_REST_ALLOW = Arrays.asList(
            DEFAULT,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW,
            ALLOW
    );

    static List<EventFutureAssessment> SINGLE_DEFAULT_REST_DENY = Arrays.asList(
            DEFAULT,
            DENY,
            DENY,
            DENY,
            DENY,
            DENY
    );

    static List<List<EventFutureAssessment>> lists = Arrays.asList(
            MIXED_ASSESSMENTS,
            ALL_ALLOW,
            ALL_DENY,
            ALL_DEFAULT,
            SINGLE_ALLOW_REST_DENY,         //5
            SINGLE_ALLOW_REST_DEFAULT,
            SINGLE_DENY_REST_ALLOW,
            SINGLE_DENY_REST_DEFAULT,
            SINGLE_DEFAULT_REST_ALLOW,
            SINGLE_DEFAULT_REST_DENY        //10
    );

    /**
     * Throws the decision maker against the lists and checks its input
     *
     * @param decisionMaker the decision maker
     * @param assessments   the array with expected outcomes
     *                      (will throw IOOB-exception if there are less than 10 entries)
     */
    private void testDecisionMaker(IEventFutureDecisionMaker decisionMaker, EventFutureAssessment... assessments) {
        for (int i = 0; i < lists.size(); i++) {
            assertEquals(assessments[i], decisionMaker.decide(lists.get(i)));
        }
    }

    private void testDecisionMaker(IEventFutureDecisionMaker decisionMaker, List<Tuple<List<EventFutureAssessment>, EventFutureAssessment>> tuples) {
        tuples.forEach(t -> assertEquals(t.getSecond(), decisionMaker.decide(t.getFirst())));
    }


    @Test
    void orDecisionMakers() {
        IEventFutureDecisionMaker or_deny = DefaultEventFutureDecisionMakers.LOGIC_OR_DENY;
        IEventFutureDecisionMaker or_default = DefaultEventFutureDecisionMakers.LOGIC_OR_DEFAULT;

        EventFutureAssessment[] or_deny_expected = {
                ALLOW,
                ALLOW,
                DENY,
                DENY,
                ALLOW,      //5
                ALLOW,
                ALLOW,
                DENY,
                ALLOW,
                DENY        //10
        };

        EventFutureAssessment[] or_default_expected = {
                ALLOW,
                ALLOW,
                DEFAULT,
                DEFAULT,
                ALLOW,      //5
                ALLOW,
                ALLOW,
                DEFAULT,
                ALLOW,
                DEFAULT     //10
        };

        testDecisionMaker(or_deny, or_deny_expected);
        testDecisionMaker(or_default, or_default_expected);
    }

    @Test
    void andDecisionMakers() {
        testDecisionMaker(DefaultEventFutureDecisionMakers.LOGIC_AND_DENY, Arrays.asList(
                new Tuple<>(MIXED_ASSESSMENTS, DENY),
                new Tuple<>(ALL_ALLOW, ALLOW),
                new Tuple<>(ALL_DEFAULT, ALLOW),
                new Tuple<>(ALL_DENY, DENY),
                new Tuple<>(SINGLE_ALLOW_REST_DEFAULT, ALLOW),      //5
                new Tuple<>(SINGLE_ALLOW_REST_DENY, DENY),
                new Tuple<>(SINGLE_DEFAULT_REST_ALLOW, ALLOW),
                new Tuple<>(SINGLE_DEFAULT_REST_DENY, DENY),
                new Tuple<>(SINGLE_DENY_REST_ALLOW, DENY),
                new Tuple<>(SINGLE_DENY_REST_DEFAULT, DENY)       //10
        ));
    }
}