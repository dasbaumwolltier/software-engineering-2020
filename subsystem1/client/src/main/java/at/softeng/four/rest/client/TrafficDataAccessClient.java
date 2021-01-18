package at.softeng.four.rest.client;

import at.softeng.four.model.link.TrafficLinkData;
import at.softeng.four.rest.TrafficDataAccess;

import java.util.List;

public class TrafficDataAccessClient extends RestClient<TrafficDataAccess> implements TrafficDataAccess{

    public TrafficDataAccessClient(String baseUrl) {
        super(baseUrl, TrafficDataAccess.class);
    }

    @Override
    public List<TrafficLinkData> getTrafficLinks() {
        return this.getClient().getTrafficLinks();
    }

    @Override
    public TrafficLinkData getTrafficLink(long trafficLinkId) {
        return this.getClient().getTrafficLink(trafficLinkId);
    }
}
