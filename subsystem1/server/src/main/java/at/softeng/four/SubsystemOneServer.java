package at.softeng.four;

import at.softeng.four.mocking.MockClasses;
import at.softeng.four.model.Coordinates;
import at.softeng.four.model.RoadGrid;
import at.softeng.four.model.ServerStatus;
import at.softeng.four.model.TrafficParticipant;
import at.softeng.four.model.device.*;
import at.softeng.four.model.link.Intersection;
import at.softeng.four.model.link.Road;
import at.softeng.four.model.link.TrafficLink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SubsystemOneServer {
    public static final ExecutorService GLOBAL_EXECUTOR = Executors.newCachedThreadPool();

    private static ServerStatus status;

    public static ServerStatus getStatus() {
        return status;
    }

    public static void setStatus(ServerStatus status) {
        SubsystemOneServer.status = status;
    }

    @Bean
    public RoadGrid roadGrid() {
        // Build mock Roadgrid
        RoadGrid roadGrid = new RoadGrid();

        Road road1 = new Road(17893);
        Road road2 = new Road(24854);
        Road road3 = new Road(31239);
        Road road4 = new Road(46569);

        Intersection intersection1 = new Intersection(35761);
        Intersection intersection2 = new Intersection(29762);
        Intersection intersection3 = new Intersection(94593);
        Intersection intersection4 = new Intersection(67864);
        /*
            I1-----road1-----I2
            |                 |
           road4             road2
            |                 |
            I4-----road3-----I3

         */
        road1.addNeighbour(intersection1);
        road1.addNeighbour(intersection2);

        road2.addNeighbour(intersection2);
        road2.addNeighbour(intersection3);

        road3.addNeighbour(intersection3);
        road3.addNeighbour(intersection4);

        road4.addNeighbour(intersection4);
        road4.addNeighbour(intersection1);

        intersection1.addNeighbour(road4);
        intersection1.addNeighbour(road1);

        intersection2.addNeighbour(road1);
        intersection2.addNeighbour(road2);

        intersection3.addNeighbour(road2);
        intersection3.addNeighbour(road3);

        intersection4.addNeighbour(road3);
        intersection4.addNeighbour(road4);

        roadGrid.addTrafficLink(road1);
        roadGrid.addTrafficLink(road2);
        roadGrid.addTrafficLink(road3);
        roadGrid.addTrafficLink(road4);

        roadGrid.addTrafficLink(intersection1);
        roadGrid.addTrafficLink(intersection2);
        roadGrid.addTrafficLink(intersection3);
        roadGrid.addTrafficLink(intersection4);

        Random rng = new Random();
        // generate Mock data
        for(TrafficLink link : roadGrid.getTrafficLinks()) {
            PresenceEventSensor lidar = new Lidar(rng.nextInt(), new Coordinates(rng.nextInt(100), rng.nextInt(100)), TrafficDeviceStatus.OPERATIONAL, link);
            PresenceEventSensor inductionLoop = new InductionLoop(rng.nextInt(), new Coordinates(rng.nextInt(100), rng.nextInt(100)), TrafficDeviceStatus.OPERATIONAL, link);
            TrafficParticipantDetectionSensor camera = new Camera(rng.nextInt(), new Coordinates(rng.nextInt(100), rng.nextInt(100)), TrafficDeviceStatus.OPERATIONAL, link);

            if(link instanceof Intersection) {
                link.addTrafficDevice(new TrafficLight(rng.nextInt(), new Coordinates(rng.nextInt(100), rng.nextInt(100)), TrafficDeviceStatus.OPERATIONAL, link));
            } else if(link instanceof Road) {
                link.addTrafficDevice(new RoadSign(rng.nextInt(), new Coordinates(rng.nextInt(100), rng.nextInt(100)), TrafficDeviceStatus.OPERATIONAL, link));
            }

            GLOBAL_EXECUTOR.submit(lidar);
            GLOBAL_EXECUTOR.submit(inductionLoop);

            link.addTrafficDevice(lidar);
            link.addTrafficDevice(camera);
        }

        List<TrafficLink> trafficLinks = roadGrid.getTrafficLinks();
        for(TrafficParticipant trafficParticipant : MockClasses.mockTrafficParticipants) {
            trafficParticipant.setTrafficLink(trafficLinks.get(rng.nextInt(trafficLinks.size())));
            roadGrid.addTrafficParticipant(trafficParticipant);
        }

        GLOBAL_EXECUTOR.submit(roadGrid);
        return roadGrid;
    }

    public static void main(String[] args) {
        status = ServerStatus.STARTING;

        SpringApplication.run(SubsystemOneServer.class, args);

        status = ServerStatus.OPERATIONAL;
    }

    @PreDestroy
    public void shutdown() {
        status = ServerStatus.SHUTTING_DOWN;
    }
}
