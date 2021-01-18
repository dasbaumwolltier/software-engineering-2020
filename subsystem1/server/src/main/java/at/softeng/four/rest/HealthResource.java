package at.softeng.four.rest;

import at.softeng.four.SubsystemOneServer;
import at.softeng.four.model.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthResource {

    @GetMapping("/heartbeat")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void heartbeat() { }

    @GetMapping("/status")
    public ServerStatus status() {
        return SubsystemOneServer.getStatus();
    }
}
