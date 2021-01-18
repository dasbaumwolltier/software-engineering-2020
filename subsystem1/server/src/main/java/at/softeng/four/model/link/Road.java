package at.softeng.four.model.link;

import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.TrafficDevice;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Road implements TrafficLink {
    private final long id;

    @JsonIgnore
    private final List<TrafficLink> neighbours = new ArrayList<>();
    private final Map<Long, TrafficDevice> trafficControlDevices = new ConcurrentHashMap<>();
    private final Map<Long, TrafficParticipant> trafficParticipants = new ConcurrentHashMap<>();


    public Road(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public double getLoadFactor() {
        // Mock Load Factor
        return Math.random();
    }

    @Override
    public void setLoadFactor(double loadFactor) { }

    @Override
    public void addNeighbour(TrafficLink newNeighbour) {
        this.neighbours.add(newNeighbour);
    }

    @Override
    public List<TrafficLink> getNeighbours() {
        return this.neighbours;
    }

    @Override
    public TrafficDevice getTrafficDevice(long id) {
        return trafficControlDevices.get(id);
    }

    @Override
    public List<TrafficDevice> getTrafficDevices() {
        return new ArrayList<>(trafficControlDevices.values());
    }

    public void addTrafficDevice(TrafficDevice tcd) {
        trafficControlDevices.put(tcd.getId(), tcd);
    }

    @Override
    public Map<Long, TrafficParticipant> getSimulatedTrafficParticipants() {
        return this.simulatedTrafficParticipants;
    }

    @Override
    public List<TrafficParticipant> getTrafficParticipants() {
        return new ArrayList<>(this.trafficParticipants.values());
    }

    @Override
    public TrafficParticipant getTrafficParticipant(long id) {
        return this.trafficParticipants.get(id);
    }

    @Override
    public void addTrafficParticipant(TrafficParticipant trafficParticipant) {
        this.trafficParticipants.put(trafficParticipant.getId(), trafficParticipant);
    }
}
