package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.link.TrafficLink;

import java.util.List;

public class Camera extends TrafficParticipantDetectionSensor {
    public Camera(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    @Override
    public List<TrafficParticipant> detectTrafficParticipants() {
        return this.parent.getTrafficParticipants();
    }
}
