package at.softeng.four.model;

import at.softeng.four.model.link.TrafficLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class RoadGrid implements Runnable {
    private final List<TrafficParticipant> trafficParticipants = new ArrayList<>();
    private final Map<Long, TrafficLink> trafficLinks = new ConcurrentHashMap<>();

    public void addTrafficLink(TrafficLink link) {
        trafficLinks.put(link.getId(), link);
    }

    public TrafficLink getTrafficLink(long id) {
        return trafficLinks.get(id);
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
            if(rng.nextDouble() > .5) {
                TrafficParticipant tp = trafficParticipants.get(rng.nextInt(trafficParticipants.size()));
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
        System.out.println("Processed command for "+command.getTrafficControlDeviceId());
        return new Result(true);
    }
}
