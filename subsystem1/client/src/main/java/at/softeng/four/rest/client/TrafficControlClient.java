package at.softeng.four.rest.client;

import at.softeng.four.model.Command;
import at.softeng.four.model.Result;
import at.softeng.four.rest.TrafficControl;


public class TrafficControlClient extends RestClient<TrafficControl> implements TrafficControl {

    public TrafficControlClient(String url) {
        super(url, TrafficControl.class);
    }

    @Override
    public Result sendCommand(Command command) {
        return this.getClient().sendCommand(command);
    }
}
