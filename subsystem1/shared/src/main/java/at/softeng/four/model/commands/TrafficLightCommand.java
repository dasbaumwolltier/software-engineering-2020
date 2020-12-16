package at.softeng.four.model.commands;

import at.softeng.four.model.device.Phase;

import java.util.List;

public class TrafficLightCommand implements TrafficControlDeviceCommand {
    private List<Phase> cycle;

    public List<Phase> getCycle() {
        return cycle;
    }

    public void setCycle(List<Phase> cycle) {
        this.cycle = cycle;
    }
}
