package game_xo.controllers;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for(int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                try {
                    if(field.getFigure(new Point(x, y)) != null) {
                        countFigure++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if(countFigure == field.getSize()*field.getSize()) return null;
        if(countFigure % 2 == 0) return Figure.X;
        return Figure.O;
    }
}
