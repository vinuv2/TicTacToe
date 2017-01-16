package test.incture.tictactoe.controller;

import com.incture.tictactoe.controller.Game;
import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;
import com.incture.tictactoe.view.Presenter;
import com.incture.tictactoe.view.Presenter2D;
import com.incture.tictactoe.view.ViewConsole;

public class GameManualTest {

	public static void main(String[] args) {
		Game game = new Game();
		Presenter presenter = new Presenter2D(new ViewConsole());
		BoardAbstract board = game.makeBoard(presenter);
		Player[] players = game.makePlayers(presenter);
		game.run(board, players, presenter);
	}
}