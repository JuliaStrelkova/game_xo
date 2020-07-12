package game_xo;

import game_xo.model.Field;
import game_xo.model.Figure;
import game_xo.model.Game;
import game_xo.model.Player;
import game_xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Yuliua";
        final String name2 = "Nikita";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.O);
        players[1] = new Player(name2, Figure.X);

        final Game XOGame = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(XOGame);
        while(consoleView.move(XOGame)) {
            consoleView.show(XOGame);
        }
    }
}
