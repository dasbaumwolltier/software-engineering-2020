package at.softeng.four.model;

public enum TpType {
    EMERGENCY_SERVICE(4),
    PUBLIC_TRANSPORT(3),
    TRANSPORT_SERVICE(2),
    PRIVATE_USE(1);

    public final int maxPriority;

    //max priority is 4, lowest 1
    private TpType(int maxPriority) {
        this.maxPriority = maxPriority;
    }
}
