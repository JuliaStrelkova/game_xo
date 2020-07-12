package game_xo.view;

import game_xo.controllers.CurrentMoveController;
import game_xo.controllers.MoveController;
import game_xo.controllers.WinnerController;
import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.Game;
import game_xo.model.exceptions.AlreadyOccupiedException;
import game_xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();

    public void show( final Game game) {
        System.out.format("Game name %s\n", game.getName());
        Field field = game.getField();
        for(int x = 0; x < field.getSize(); x++){
            if(x != 0)
                printSeparator();
            printLine(field, x);
        }


    }

    public boolean move (final Game game) {
        final Field field = game.getField();
        final Figure figure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.println();
            System.out.format("Winner is %s\n", winner);
            return false;
        }
        System.out.println();
        if(figure == null ) {
            System.out.println("No winner and no move left!");
            return false;

        }
        System.out.println();
        System.out.format("Pleas enter move point for %s\n", figure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(point, field, figure);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName){
        System.out.println();
        System.out.format("Pleas input %s: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Invalid format");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine( final Field field, final int x) {

        for(int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print(" |");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y,x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~");
    }
}
