package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

public interface TrafficDevice {
    long getId();
    Coordinates getGeographicPosition();
    TrafficDeviceStatus getStatus();
    TrafficLink getParent();
}
