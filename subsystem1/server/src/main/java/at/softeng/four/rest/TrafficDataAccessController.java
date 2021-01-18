package at.softeng.four.rest;

import at.softeng.four.model.RoadGrid;
import at.softeng.four.model.link.TrafficLink;
import at.softeng.four.model.link.TrafficLinkData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class TrafficDataAccessController implements TrafficDataAccess {
    private final RoadGrid roadGrid;

    @Autowired
    public TrafficDataAccessController(RoadGrid grid) {
        this.roadGrid = grid;
    }

    @Override
    @GetMapping("/link")
    public List<TrafficLinkData> getTrafficLinks() {
        return this.roadGrid.getTrafficLinksData();
    }

    @Override
    @GetMapping("link/{id}")
    public TrafficLinkData getTrafficLink(@PathVariable long trafficLinkId) {
        return this.roadGrid.getTrafficLinkData(trafficLinkId);
    }
}
