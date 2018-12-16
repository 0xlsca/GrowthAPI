package tomconn.growthapi.prepackaged.decision_logic_unit;

import tomconn.growthapi.base.decision_logic_unit.EventFutureAssessment;
import tomconn.growthapi.base.decision_logic_unit.ILocalEventFutureDecisionUnit;

import java.util.List;

public class DefaultLocalDecisionLogicUnits {

    /**
     * This is a helper method which is used for applying or-logic on the provided list
     *
     * @param list     the list
     * @param positive returned if there was an assessment found which equals {@code complements}
     * @param negative returned if there was no assessment found which equals {@code complements}
     * @return either {@code positive} or {@code negative}
     */
    public static EventFutureAssessment bulkProcessOr(List<Boolean> list, EventFutureAssessment negative, EventFutureAssessment positive) {
        if (list.stream().anyMatch(bool -> bool)) {
            return positive;
        }
        return negative;
    }

    /**
     * This is a helper method which is used for applying and-logic on the provided list
     *
     * @param list     the list
     * @param positive returned if there was an assessment found which equals {@code complements}
     * @param negative returned if there was no assessment found which equals {@code complements}
     * @return either {@code positive} or {@code negative}
     */
    public static EventFutureAssessment bulkProcessAnd(List<Boolean> list, EventFutureAssessment negative, EventFutureAssessment positive) {
        if (list.stream().anyMatch(bool -> !bool)) {
            return negative;
        }
        return positive;
    }

    public final static ILocalEventFutureDecisionUnit ALWAYS_ALLOW = (ignored) -> EventFutureAssessment.ALLOW;
    public final static ILocalEventFutureDecisionUnit ALWAYS_DENY = (ignored) -> EventFutureAssessment.DENY;
    public final static ILocalEventFutureDecisionUnit ALWAYS_DEFAULT = (ignored) -> EventFutureAssessment.DEFAULT;

    public final static ILocalEventFutureDecisionUnit LOGIC_OR_DENY = (boolList) -> bulkProcessOr(boolList, EventFutureAssessment.DENY, EventFutureAssessment.ALLOW);
    public final static ILocalEventFutureDecisionUnit LOGIC_OR_DEFAULT = (boolList) -> bulkProcessOr(boolList, EventFutureAssessment.DEFAULT, EventFutureAssessment.ALLOW);

    public final static ILocalEventFutureDecisionUnit LOGIC_AND_DENY = (boolList) -> bulkProcessAnd(boolList, EventFutureAssessment.DENY, EventFutureAssessment.ALLOW);
    public final static ILocalEventFutureDecisionUnit LOGIC_AND_DEFAULT = (boolList) -> bulkProcessAnd(boolList, EventFutureAssessment.DEFAULT, EventFutureAssessment.ALLOW);
}
