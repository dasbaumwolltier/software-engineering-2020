package at.softeng.four.rest;

import at.softeng.four.model.Command;
import at.softeng.four.model.Result;
import at.softeng.four.model.RoadGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/control")
public class TrafficControlController implements TrafficControl {

    private RoadGrid roadGrid;

    @Autowired
    public TrafficControlController(RoadGrid roadGrid) {
        this.roadGrid = roadGrid;
    }

    @Override
    @PostMapping("/command")
    public Result sendCommand(@RequestBody Command command) {
        return roadGrid.sendCommand(command);
    }
}
