package at.softeng.four.mocking;

import at.softeng.four.model.TpType;
import at.softeng.four.model.TrafficParticipant;

import java.util.Arrays;
import java.util.List;

public class MockClasses {
    public static final List<TrafficParticipant> mockTrafficParticipants = Arrays.asList(
        new TrafficParticipant(2, "Martha Hudson", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(3, "Gregory Lestrade", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(4, "Lestrade", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(5, "Irene Adler", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(6, "James Moriarty", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(7, "Mycroft Holmes", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(8, "Sherlock Holmes", TpType.PRIVATE_USE, 0, 0),
        new TrafficParticipant(9, "John Watson", TpType.PRIVATE_USE, 0, 0),

        new TrafficParticipant(10, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(11, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(12, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(13, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(14, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(15, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(16, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(17, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(18, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),
        new TrafficParticipant(19, "City Transport Company", TpType.PUBLIC_TRANSPORT, 0, 0),

        new TrafficParticipant(21, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),
        new TrafficParticipant(22, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),
        new TrafficParticipant(23, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),
        new TrafficParticipant(24, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),
        new TrafficParticipant(25, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),
        new TrafficParticipant(26, "Red Cross", TpType.EMERGENCY_SERVICE, 0, 0),

        new TrafficParticipant(27, "Red Truck Company", TpType.TRANSPORT_SERVICE, 0, 0),
        new TrafficParticipant(28, "Red Truck Company", TpType.TRANSPORT_SERVICE, 0, 0),
        new TrafficParticipant(29, "Red Truck Company", TpType.TRANSPORT_SERVICE, 0, 0)
    );
}
