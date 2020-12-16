package at.softeng.four.model.device;

import at.softeng.four.model.Coordinates;
import at.softeng.four.model.link.TrafficLink;

import java.util.Arrays;
import java.util.List;

public class TrafficLight extends IntersectionControlDevice {
    private List<Phase> cycle = Arrays.asList(new Phase(1000, TrafficLightPhase.YELLOW_BLINK));

    public TrafficLight(long id, Coordinates geographicPosition, TrafficDeviceStatus status, TrafficLink parent) {
        super(id, geographicPosition, status, parent);
    }

    public List<Phase> getCycle() {
        return cycle;
    }

    public void setCycle(List<Phase> cycle) {
        this.cycle = cycle;
    }
}
