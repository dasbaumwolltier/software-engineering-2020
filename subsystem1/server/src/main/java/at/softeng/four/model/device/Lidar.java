package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

import static at.softeng.four.SubsystemOneServer.GLOBAL_EXECUTOR;

public class Lidar extends PresenceEventSensor {
    private final double chance = Math.random() / 2;

    public Lidar(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    @Override
    public void run() {
        while(true) {
            //Simulate traffic behaviour
            if(this.parent.getTrafficParticipants().size() > 0) {
                GLOBAL_EXECUTOR.submit(this.onPresenceDetection);
            }

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
