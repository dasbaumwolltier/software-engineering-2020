package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

public class DefaultTrafficDevice implements TrafficDevice {
    protected final long id;
    protected final Coordinates geographicPosition;
    protected final TrafficLink parent;

    private TrafficDeviceStatus status;

    public DefaultTrafficDevice(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        this.id = id;
        this.geographicPosition = geographicPosition;
        this.status = status;
        this.parent = parent;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Coordinates getGeographicPosition() {
        return this.geographicPosition;
    }

    public TrafficLink getParent() {
        return parent;
    }

    @Override
    public TrafficDeviceStatus getStatus() {
        return this.status;
    }
}
