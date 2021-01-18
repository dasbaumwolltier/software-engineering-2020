package at.softeng.four.rest;

import at.softeng.four.model.Command;
import at.softeng.four.model.Result;
import feign.Headers;
import feign.RequestLine;

public interface TrafficControl {
    @RequestLine("POST /api/control/command")
    @Headers("Content-Type: application/json")
    Result sendCommand(Command command);
}
