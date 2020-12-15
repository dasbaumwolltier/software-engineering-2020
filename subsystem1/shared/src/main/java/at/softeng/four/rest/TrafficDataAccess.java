package at.softeng.four.rest;

import at.softeng.four.model.link.TrafficLink;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TrafficDataAccess {
    @RequestLine("GET /api/data/link")
    List<TrafficLink> getTrafficLinks();

    @RequestLine("GET /api/data/link/{id}")
    TrafficLink getTrafficLink(@Param("id") long trafficLinkId);
}
