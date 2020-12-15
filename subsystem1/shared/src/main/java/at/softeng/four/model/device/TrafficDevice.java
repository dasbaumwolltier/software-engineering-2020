package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;

public interface TrafficDevice {
    long getId();
    Coordinates getGeographicPosition();
    TrafficDeviceStatus getStatus();
}
