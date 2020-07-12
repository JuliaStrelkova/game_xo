package game_xo.controllers;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(final Field field)  {
        try {
            for(int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) return field.getFigure(new Point(i, 0));
            }

            for(int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) return field.getFigure(new Point(0, i));
            }

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) return field.getFigure(new Point(0, 2));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check (final Field field, final Point pointStart, IPointChanger pointChanger) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(pointStart);
        try {
            currentFigure = field.getFigure(pointStart);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            // если программа дошла до конца поля, значит все значения одинаковые и игрок выиграл
            return true;
        }
        if(currentFigure == null || currentFigure != nextFigure) return false;
        return check(field, nextPoint, pointChanger);
    }
    private  interface IPointChanger {

        Point next(final Point p);
    }
}
