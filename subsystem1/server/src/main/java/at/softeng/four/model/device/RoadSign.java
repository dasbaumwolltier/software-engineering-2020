package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.commands.RoadSignType;
import at.softeng.four.model.link.TrafficLink;

public class RoadSign extends RoadControlDevice {
    private int speed;
    private RoadSignType roadSignType = RoadSignType.ROAD_BLOCK_SIGN;

    public RoadSign(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public RoadSignType getRoadSignType() {
        return roadSignType;
    }

    public void setRoadSignType(RoadSignType roadSignType) {
        this.roadSignType = roadSignType;
    }
}
