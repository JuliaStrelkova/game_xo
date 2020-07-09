package game_xo.controllers;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.exceptions.AlreadyOccupiedException;
import game_xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Point point, final Field field, Figure figure) throws AlreadyOccupiedException, InvalidPointException {
        if(field.getFigure(point) != null ) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point,figure);
    }
}
