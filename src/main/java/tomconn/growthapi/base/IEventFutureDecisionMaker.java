package tomconn.growthapi.base;

import java.util.List;

@FunctionalInterface
public interface IEventFutureDecisionMaker {

    /**
     * Decides based on the given list of assessments whether or not how the event will be handled
     *
     * @param assessments the assessments provided by all eligible {@link ICompositeEventProcessor}
     * @return the respective result of the decision as {@link EventFutureAssessment}
     */
    EventFutureAssessment decide(List<EventFutureAssessment> assessments);
}
