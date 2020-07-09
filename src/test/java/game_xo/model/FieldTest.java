package game_xo.model;

import game_xo.model.exceptions.AlreadyOccupiedException;
import game_xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void getFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }
    @Test
    void getFigureWhenXIsNotCorrect() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenYIsNotCorrect() {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenXAndYIsNotCorrect() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,-1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenXMoreThenSize(){
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenYMoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenXAndYMoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,field.getSize() + 1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){

        }
    }

    @Test
    void getFigureWhenPointAlreadyOccupied() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        field.setFigure(inputPoint, Figure.O);
        try {
            field.setFigure(inputPoint, Figure.X);
            fail();
        } catch (final AlreadyOccupiedException e){

        }
    }
}