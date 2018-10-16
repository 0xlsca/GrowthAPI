package tomconn.growthapi.base;

import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * A mirror of Forge's {@link net.minecraftforge.fml.common.eventhandler.Event.Result}, providing currenlty supported results.
 * <br>
 * Each entry has an associated {@link net.minecraftforge.fml.common.eventhandler.Event.Result}
 */
public enum EventFutureAssessment {
    ALLOW(Event.Result.ALLOW),
    DENY(Event.Result.DENY),
    DEFAULT(Event.Result.DEFAULT);

    private final Event.Result result;

    EventFutureAssessment(Event.Result eventResult) {
        result = eventResult;
    }

    public Event.Result getResult() {
        return result;
    }
}
