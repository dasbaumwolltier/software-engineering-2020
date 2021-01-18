package at.softeng.four.model;

import at.softeng.four.model.link.TrafficLink;
import at.softeng.four.model.link.TrafficLinkData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RoadGrid implements Runnable {
    private final List<TrafficParticipant> trafficParticipants = new ArrayList<>();
    private final Map<Long, TrafficLink> trafficLinks = new ConcurrentHashMap<>();

    private final List<Command> commandLog = new LinkedList<>();

    public void addTrafficLink(TrafficLink link) {
        trafficLinks.put(link.getId(), link);
    }

    public TrafficLink getTrafficLink(long id) {
        return trafficLinks.get(id);
    }

    public TrafficLinkData getTrafficLinkData(long id) {
        return new TrafficLinkData(trafficLinks.get(id));
    }

    public List<TrafficLinkData> getTrafficLinksData() {
        return trafficLinks.values().stream().map(link -> new TrafficLinkData(link)).collect(Collectors.toList());
    }

    public List<TrafficLink> getTrafficLinks() {
        return new ArrayList<>(trafficLinks.values());
    }

    //For Mocking
    public void addTrafficParticipant(TrafficParticipant trafficParticipant) {
        this.trafficParticipants.add(trafficParticipant);
    }

    public List<TrafficParticipant> getTrafficParticipants() {
        return trafficParticipants;
    }

    @Override
    public void run() {
        Random rng = new Random();

        while(true) {
            if(rng.nextDouble() >= .5) {
                TrafficParticipant tp = this.trafficParticipants.get(rng.nextInt(this.trafficParticipants.size()));
                System.out.println("Move " + tp);
                List<TrafficLink> neighbours = tp.getTrafficLink().getNeighbours();
                tp.setTrafficLink(neighbours.get(rng.nextInt(neighbours.size())));
            }

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Result sendCommand(Command command) {
        commandLog.add(command);
        System.out.println("Processed command for "+command.getTrafficControlDeviceId());
        return new Result(true);
    }

    public List<Command> getCommandLog() {
        return Collections.unmodifiableList(commandLog);
    }
}
