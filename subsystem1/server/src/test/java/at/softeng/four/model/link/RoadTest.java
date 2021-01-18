package at.softeng.four.model.link;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.TpType;
import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.Camera;
import at.softeng.four.model.device.TrafficDevice;
import at.softeng.four.model.device.TrafficDeviceStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoadTest {
    public Road road = new Road(0, 4);

    @Test
    public void testAddTrafficDevice() {
        TrafficDevice td = new Camera(0, new Coordinates(0, 0), TrafficDeviceStatus.OPERATIONAL, road);
        this.road.addTrafficDevice(td);
        Assertions.assertEquals(td, this.road.getTrafficDevice(td.getId()));
    }

    @Test
    public void testGetLoadFactor() {
        TrafficDevice td = new Camera(0, new Coordinates(0, 0), TrafficDeviceStatus.OPERATIONAL, road);
        Assertions.assertEquals(0, this.road.getLoadFactor());

        this.road.addTrafficParticipant(new TrafficParticipant(0, "", TpType.EMERGENCY_SERVICE, 0, 0));
        Assertions.assertEquals(0.25, this.road.getLoadFactor());
    }
}
