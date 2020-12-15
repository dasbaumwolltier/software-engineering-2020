package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;

public abstract class Sensor extends DefaultTrafficDevice {
    public Sensor(long id, Coordinates geographicPosition, TrafficDeviceStatus status) {
        super(id, geographicPosition, status);
    }
}
