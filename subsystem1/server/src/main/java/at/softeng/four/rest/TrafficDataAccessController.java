package at.softeng.four.rest;

import at.softeng.four.model.RoadGrid;
import at.softeng.four.model.link.TrafficLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/data")
public class TrafficDataAccessController implements TrafficDataAccess {
    private final RoadGrid roadGrid;

    @Autowired
    public TrafficDataAccessController(RoadGrid grid) {
        this.roadGrid = grid;
    }

    @Override
    @GetMapping("/link")
    public List<TrafficLink> getTrafficLinks() {
        return this.roadGrid.getTrafficLinks();
    }

    @Override
    public TrafficLink getTrafficLink(long trafficLinkId) {
        return this.roadGrid.getTrafficLink(trafficLinkId);
    }
}
