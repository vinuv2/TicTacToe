package test.incture.tictactoe.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.incture.tictactoe.controller.Game;
import com.incture.tictactoe.model.Board2D;
import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;
import com.incture.tictactoe.view.Presenter;
import com.incture.tictactoe.view.Presenter2D;
import com.incture.tictactoe.view.View;
import com.incture.tictactoe.view.ViewMockString;

public class GameAutomatedTest {

	
	@Test
	public void testRun() {
		Game game = new Game();
		BoardAbstract board = new Board2D(2);
		Player[] players = new Player[2];
		Player player1 = new Player("Joe", '0');
		Player player2 = new Player("Lis", 'X');
		players[0] = player1;
		players[1] = player2;
		String source = "1 1 0 0 1 0 0 1";
		View viewArg = new ViewMockString(source);
		Presenter presenter = new Presenter2D(viewArg);
		assertTrue(game.run(board, players, presenter));
	}

	@Test
	public void testRun2() {
		Game game = new Game();
		String source = "2 2\n2\nTom X\nBen Y\n1 1\n0 0\n1 0";
		Presenter presenter = new Presenter2D(new ViewMockString(source));
		BoardAbstract board = game.makeBoard(presenter);
		Player[] players = game.makePlayers(presenter);
		assertTrue(game.run(board, players, presenter));
	}
}