package game_xo.controllers;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    public void getWinnerWhenWinnerRow() {
        final WinnerController winnerController = new WinnerController();
        try {
            for(int i = 0; i < 3; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(i, 0), Figure.O);
                field.setFigure(new Point(i, 1), Figure.O);
                field.setFigure(new Point(i, 2), Figure.O);
                assertEquals(Figure.O, winnerController.getWinner(field));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenWinnerColumn() {
        final WinnerController winnerController = new WinnerController();
        try {
            for(int i = 0; i < 3; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(0, i), Figure.O);
                field.setFigure(new Point(1, i), Figure.O);
                field.setFigure(new Point(2, i), Figure.O);
                assertEquals(Figure.O, winnerController.getWinner(field));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn() {
        final WinnerController winnerController = new WinnerController();
        try {
            for(int i = 0; i < 3; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(0, i), Figure.O);
                field.setFigure(new Point(1, i), Figure.O);
                field.setFigure(new Point(2, i), Figure.X);
                assertNull(winnerController.getWinner(field));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenWinnerDiag1() {
        final WinnerController winnerController = new WinnerController();
        try {
                final Field field = new Field(3);
                field.setFigure(new Point(0, 0), Figure.O);
                field.setFigure(new Point(1, 1), Figure.O);
                field.setFigure(new Point(2, 2), Figure.O);
                assertEquals(Figure.O, winnerController.getWinner(field));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenNoWinnerDiag1() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 2), Figure.X);
            assertNull(winnerController.getWinner(field));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenWinnerDiag2() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 2), Figure.O);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 0), Figure.O);
            assertEquals(Figure.O, winnerController.getWinner(field));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenNoWinnerDiag2() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 2), Figure.O);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 0), Figure.X);
            assertNull(winnerController.getWinner(field));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWinnerWhenNoWinnerRow() {
        final WinnerController winnerController = new WinnerController();
        try {
            for(int i = 0; i < 3; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(i, 0), Figure.O);
                field.setFigure(new Point(i, 1), Figure.O);
                field.setFigure(new Point(i, 2), Figure.X);
                assertNull(winnerController.getWinner(field));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

}