package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;

public class DefaultTrafficDevice implements TrafficDevice {
    private long id;
    private Coordinates geographicPosition;
    private TrafficDeviceStatus status;

    public DefaultTrafficDevice(long id, Coordinates geographicPosition, TrafficDeviceStatus status) {
        this.id = id;
        this.geographicPosition = geographicPosition;
        this.status = status;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Coordinates getGeographicPosition() {
        return this.geographicPosition;
    }

    @Override
    public TrafficDeviceStatus getStatus() {
        return this.status;
    }
}
