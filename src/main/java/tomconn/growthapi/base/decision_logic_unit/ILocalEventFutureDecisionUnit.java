package tomconn.growthapi.base.decision_logic_unit;

import java.util.List;

@FunctionalInterface
public interface ILocalEventFutureDecisionUnit {

    EventFutureAssessment decide(List<Boolean> values);
}
