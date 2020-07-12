package game_xo.controllers;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {
    @Test
    public void currentMoveWhenNextIsO() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }
    @Test
    public void currentMoveWhenNextIsX() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }
    @Test
    public void currentMoveWhenNextIsNull() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        assertNull(currentMoveController.currentMove(field));

    }

}