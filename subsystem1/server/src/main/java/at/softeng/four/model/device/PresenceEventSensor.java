package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

public abstract class PresenceEventSensor extends Sensor implements Runnable {
    protected Runnable onPresenceDetection;

    public PresenceEventSensor(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    public void setOnPresenceDetection(Runnable onPresenceDetection) {
        this.onPresenceDetection = onPresenceDetection;
    }
}
