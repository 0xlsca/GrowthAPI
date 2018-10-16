package tomconn.growthapi.prepackaged;

import tomconn.growthapi.base.EventFutureAssessment;
import tomconn.growthapi.base.IEventFutureDecisionMaker;

import java.util.Arrays;
import java.util.List;

import static tomconn.growthapi.base.EventFutureAssessment.*;

@SuppressWarnings("WeakerAccess")
public class DefaultEventFutureDecisionMakers {

    /**
     * This is a helper method which is used for applying or-logic on the provided list
     *
     * @param list        the list
     * @param positive    returned if there was an assessment found which equals {@code complements}
     * @param negative    returned if there was no assessment found which equals {@code complements}
     * @param complements the expected value of the tuple's second value in case of a positive decision
     * @return either {@code positive} or {@code negative}
     */
    public static EventFutureAssessment bulkProcessOr(List<EventFutureAssessment> list, EventFutureAssessment negative, EventFutureAssessment positive, EventFutureAssessment... complements) {
        if (list.stream().anyMatch(ass -> Arrays.stream(complements).anyMatch(compAss -> compAss == ass))) {
            return positive;
        }
        return negative;
    }

    /**
     * This is a helper method which is used for applying and-logic on the provided list
     *
     * @param list        the list
     * @param positive    returned if there was an assessment found which equals {@code complements}
     * @param negative    returned if there was no assessment found which equals {@code complements}
     * @param complements the expected value of the tuple's second value in case of a positive decision
     * @return either {@code positive} or {@code negative}
     */
    public static EventFutureAssessment bulkProcessAnd(List<EventFutureAssessment> list, EventFutureAssessment negative, EventFutureAssessment positive, EventFutureAssessment... complements) {
        if (list.stream().anyMatch(ass -> Arrays.stream(complements).noneMatch(compAss -> compAss == ass))) {
            return negative;
        }
        return positive;
    }

    public final static IEventFutureDecisionMaker ALWAYS_ALLOW = (ignored) -> ALLOW;
    public final static IEventFutureDecisionMaker ALWAYS_DENY = (ignored) -> DENY;
    public final static IEventFutureDecisionMaker ALWAYS_DEFAULT = (ignored) -> DEFAULT;

    public final static IEventFutureDecisionMaker LOGIC_OR_DENY = (list) -> bulkProcessOr(list, DENY, ALLOW, ALLOW);
    public final static IEventFutureDecisionMaker LOGIC_OR_DEFAULT = (list) -> bulkProcessOr(list, DEFAULT, ALLOW, ALLOW);

    public final static IEventFutureDecisionMaker LOGIC_AND_DENY = (list) -> bulkProcessAnd(list, DENY, ALLOW, ALLOW, DEFAULT);
    public final static IEventFutureDecisionMaker LOGIC_AND_DEFAULT = (list) -> bulkProcessAnd(list, DEFAULT, ALLOW, ALLOW, DEFAULT);
}
