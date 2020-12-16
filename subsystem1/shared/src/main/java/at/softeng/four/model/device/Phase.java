package at.softeng.four.model.device;

public class Phase {
    private long time;
    private TrafficLightPhase phase;

    public Phase(long time, TrafficLightPhase phase) {
        this.time = time;
        this.phase = phase;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public TrafficLightPhase getPhase() {
        return phase;
    }

    public void setPhase(TrafficLightPhase phase) {
        this.phase = phase;
    }

}
