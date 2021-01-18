package at.softeng.four.rest;

import at.softeng.four.model.link.TrafficLink;
import at.softeng.four.model.link.TrafficLinkData;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TrafficDataAccess {
    @RequestLine("GET /api/data/link")
    List<TrafficLinkData> getTrafficLinks();

    @RequestLine("GET /api/data/link/{id}")
    TrafficLinkData getTrafficLink(@Param("id") long trafficLinkId);
}
