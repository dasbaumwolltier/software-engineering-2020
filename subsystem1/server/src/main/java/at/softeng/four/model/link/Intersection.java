package at.softeng.four.model.link;

import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.TrafficDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Intersection implements TrafficLink {
    private final long id;
    private double loadFactor = 0;

    private final List<TrafficLink> neighbours = new ArrayList<>();
    private final Map<Long, TrafficParticipant> trafficParticipants = new ConcurrentHashMap<>();
    private final Map<Long, TrafficDevice> trafficControlDevices = new ConcurrentHashMap<>();

    public Intersection(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public double getLoadFactor() {
        return this.loadFactor;
    }

    @Override
    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public void addNeighbour(TrafficLink newNeighbour) {
        this.neighbours.add(newNeighbour);
    }

    public List<TrafficLink> getNeighbours() {
        return this.neighbours;
    }

    @Override
    public TrafficDevice getTrafficDevice(long id) {
        return this.trafficControlDevices.get(id);
    }

    @Override
    public List<TrafficDevice> getTrafficDevices() {
        return new ArrayList<>(this.trafficControlDevices.values());
    }

    public void addTrafficDevice(TrafficDevice tcd) {
        trafficControlDevices.put(tcd.getId(), tcd);
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
