package at.softeng.four.rest;

import at.softeng.four.model.Command;
import at.softeng.four.model.Result;
import feign.RequestLine;

public interface TrafficControl {
    @RequestLine("POST /api/control/command")
    Result sendCommand(Command command);
}
