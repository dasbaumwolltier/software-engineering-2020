package at.softeng.four.model.link;

import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.TrafficDevice;
import at.softeng.four.model.device.TrafficParticipantDetectionSensor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractTrafficLink implements TrafficLink {
    protected final Map<Long, TrafficDevice> trafficDevices = new ConcurrentHashMap<>();
    protected final Map<Long, TrafficParticipant> trafficParticipants = new ConcurrentHashMap<>();

    @Override
    public void trafficParticipantPresenceDetected() {
        Map<Long, TrafficParticipant> detected = this.trafficDevices.values().stream()
            .filter(device -> device instanceof TrafficParticipantDetectionSensor)
            .map(d -> (TrafficParticipantDetectionSensor)d)
            .map(TrafficParticipantDetectionSensor::detectTrafficParticipants)
            .flatMap(List::stream)
            .collect(Collectors.toMap(TrafficParticipant::getId, Function.identity()));

        processTrafficParticipants(detected);
    }

    private void processTrafficParticipants(Map<Long, TrafficParticipant> trafficParticipants) {
        trafficParticipants.values().stream()
            .filter(t -> !this.trafficParticipants.containsKey(t.getId()))
            .peek(t -> System.out.println("Detected " + t))
            .forEach(t -> this.trafficParticipants.put(t.getId(), t));

        List<Long> remove = this.trafficParticipants.entrySet().stream()
            .filter(t -> !this.trafficParticipants.containsKey(t.getKey()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        remove.forEach(this.trafficParticipants::remove);
    }

    @Override
    public String toString() {
        return String.format("Traffic link (Neighbours: %s)", getNeighbours().stream()
            .map(TrafficLink::getId)
            .map(String::valueOf)
            .reduce((a, b) -> a + ", " + b)
        );
    }
}
