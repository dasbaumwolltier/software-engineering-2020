package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.link.TrafficLink;

import java.util.List;

public abstract class TrafficParticipantDetectionSensor extends Sensor {
    public TrafficParticipantDetectionSensor(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    public abstract List<TrafficParticipant> detectTrafficParticipants();
}
