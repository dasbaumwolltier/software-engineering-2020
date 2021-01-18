package at.softeng.four.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoadGridTest {

    private RoadGrid roadGrid = new RoadGrid();

    @Test
    public void testSendCommand() {
        Command testCommand = new Command();
        testCommand.setTrafficLinkId(1);
        testCommand.setTrafficControlDeviceId(123);
        Result result = roadGrid.sendCommand(testCommand);
        assertTrue(result.isSuccess());
        assertTrue(roadGrid.getCommandLog().contains(testCommand));
    }

    @Test
    public void testImmutableCommandLog() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> roadGrid.getCommandLog().add(new Command()));
    }
}
