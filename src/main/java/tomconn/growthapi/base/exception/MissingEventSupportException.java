package tomconn.growthapi.base.exception;

import tomconn.growthapi.base.manager.IEventManager;

public class MissingEventSupportException extends RuntimeException {
    public MissingEventSupportException(IEventManager manager, String eventType) {
        super(String.format(
                "The called manager (class: %s ) does not handle %s events",
                manager.getClass().getName(), eventType)
        );
    }
}
