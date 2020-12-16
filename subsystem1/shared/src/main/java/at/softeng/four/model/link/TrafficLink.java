package at.softeng.four.model.link;

import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.TrafficDevice;

import java.util.List;
import java.util.Map;

public interface TrafficLink {
    long getId();
    
    double getLoadFactor();
    void setLoadFactor(double loadFactor);

    void addNeighbour(TrafficLink newNeighbour);
    List<TrafficLink> getNeighbours();

    TrafficDevice getTrafficDevice(long id);
    List<TrafficDevice> getTrafficDevices();
    void addTrafficDevice(TrafficDevice tcd);

    List<TrafficParticipant> getTrafficParticipants();
    TrafficParticipant getTrafficParticipant(long id);
    void addTrafficParticipant(TrafficParticipant trafficParticipant);
}
