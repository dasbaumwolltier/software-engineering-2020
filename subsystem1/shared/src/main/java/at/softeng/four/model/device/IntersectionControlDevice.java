package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;

public abstract class IntersectionControlDevice extends DefaultTrafficDevice {
    public IntersectionControlDevice(long id, Coordinates geographicPosition, TrafficDeviceStatus status) {
        super(id, geographicPosition, status);
    }
}
