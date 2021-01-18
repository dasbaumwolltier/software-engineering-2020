package at.softeng.four.model.link;

import at.softeng.four.model.device.DefaultTrafficDevice;

import java.util.List;
import java.util.stream.Collectors;

public class TrafficLinkData  {

    private long id;
    private double loadFactor;
    private List<DefaultTrafficDevice> trafficDevices;

    public TrafficLinkData(TrafficLink link) {
        this.id = link.getId();
        this.loadFactor = link.getLoadFactor();
        this.trafficDevices = link.getTrafficDevices().stream()
            .map(device -> new DefaultTrafficDevice(device.getId(), device.getGeographicPosition(), device.getStatus(), device.getParent()))
            .collect(Collectors.toList());
    }


    public long getId() {
        return id;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public List<DefaultTrafficDevice> getTrafficDevices() {
        return trafficDevices;
    }
}
