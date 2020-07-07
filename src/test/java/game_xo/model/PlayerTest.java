package game_xo.model;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void getName() {
        final String testValue = "Yuliya";
        final String expectedValue = testValue;

        final Player player = new Player(testValue, null);

        final String activeValue = player.getName();

        assertEquals(expectedValue,activeValue);
    }

    @org.junit.jupiter.api.Test
    void getFigure() {
        final Figure testValue =Figure.X;
        final Figure expectedValue = testValue;

        final Player player = new Player(null, testValue);

        final Figure activeValue = player.getFigure();

        assertEquals(expectedValue,activeValue);
    }
}