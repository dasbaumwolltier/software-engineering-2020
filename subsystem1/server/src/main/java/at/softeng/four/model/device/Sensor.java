package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

public abstract class Sensor extends DefaultTrafficDevice {
    public Sensor(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }
}
