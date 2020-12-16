package at.softeng.four.model;

import at.softeng.four.model.link.TrafficLink;

public class TrafficParticipant {
    private long id;
    private String owner;
    private TpType type = TpType.PRIVATE_USE;
    private int priority = TpType.PRIVATE_USE.maxPriority;
    private double latitude = 0;
    private double longitude = 0;

    //For Mocking
    private TrafficLink trafficLink;

    public TrafficParticipant() { }

    public TrafficParticipant(String owner, TpType type, double latitude, double longitude) {
        this.owner = owner;
        this.type = type;
        this.priority = type.maxPriority;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TrafficParticipant(long id, String owner, TpType type, double latitude, double longitude) {
        this.owner = owner;
        this.type = type;
        this.priority = type.maxPriority;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public TpType getType() {
        return type;
    }
    public void setType(TpType type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TrafficLink getTrafficLink() {
        return trafficLink;
    }
    public void setTrafficLink(TrafficLink trafficLink) {
        this.trafficLink = trafficLink;
    }
}
