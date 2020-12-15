package at.softeng.four.model.link;

import at.softeng.four.model.device.TrafficControlDevice;

import java.util.List;

public interface TrafficLink {
    long getId();
    double getLoadFactor();
    TrafficControlDevice getTrafficControlDevice(long id);
    List<TrafficControlDevice> getTrafficControlDevices();
}
