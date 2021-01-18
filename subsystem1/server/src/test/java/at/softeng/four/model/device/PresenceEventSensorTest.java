package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.link.Road;
import at.softeng.four.model.link.TrafficLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PresenceEventSensorTest {

    private ExecutorService executor = Executors.newCachedThreadPool();

    private static class PresenceEventHandlerMock implements Runnable{
        private boolean invoked = false;

        @Override
        public void run() {
            invoked = true;
        }

    }

    @Test
    public void testLidarPresenceEvent() {
        TrafficLink link = new Road(123, 5);
        link.getSimulatedTrafficParticipants().put(456L, new TrafficParticipant());

        PresenceEventSensor sensor = new Lidar(1, new Coordinates(0,0), TrafficDeviceStatus.OPERATIONAL, link);
        //Start sensor Simulation
        PresenceEventHandlerMock mock = new PresenceEventHandlerMock();
        sensor.setOnPresenceDetection(mock);
        executor.submit(sensor);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // check if sensor has triggered an event
        Assertions.assertTrue(mock.invoked);
    }
}
