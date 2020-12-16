package at.softeng.four.model;

import at.softeng.four.model.commands.TrafficControlDeviceCommand;

public class Command {
    private long trafficLinkId;
    private long trafficControlDeviceId;

    private TrafficControlDeviceCommand trafficControlDeviceCommand;

    public long getTrafficLinkId() {
        return trafficLinkId;
    }

    public void setTrafficLinkId(long trafficLinkId) {
        this.trafficLinkId = trafficLinkId;
    }

    public long getTrafficControlDeviceId() {
        return trafficControlDeviceId;
    }

    public void setTrafficControlDeviceId(long trafficControlDeviceId) {
        this.trafficControlDeviceId = trafficControlDeviceId;
    }

    public TrafficControlDeviceCommand getTrafficControlDeviceCommand() {
        return trafficControlDeviceCommand;
    }

    public void setTrafficControlDeviceCommand(TrafficControlDeviceCommand trafficControlDeviceCommand) {
        this.trafficControlDeviceCommand = trafficControlDeviceCommand;
    }
}