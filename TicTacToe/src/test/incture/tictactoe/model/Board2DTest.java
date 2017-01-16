package test.incture.tictactoe.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.incture.tictactoe.model.Board2D;
import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;

public class Board2DTest {

	private Board2D board2D;
	private int boardSize;
	private Player player;
	private Player player2;

	@Before
	public void setUp() throws Exception {
		boardSize = 3;
		board2D = new Board2D(boardSize);
		player = new Player("Tester", '1');
		player2 = new Player("Tester2", '0');
	}

	@Test
	public void testGetDimension() {
		int boardSize = 3;
		BoardAbstract twoDimensionalBoard = new Board2D(boardSize);
		assertEquals(2, twoDimensionalBoard.getDimension());

		// BoardAbstract threeDimensionalBoard = new Board3D(boardSize);
		// assertEquals(boardSize, threeDimensionalBoard.getDimension());
		//
		// assertNotEquals(2, threeDimensionalBoard.getDimension());
	}

	@Test
	public void testGetBoardSize() {
		BoardAbstract twoDimensionalBoard = new Board2D(boardSize);
		assertEquals(boardSize, twoDimensionalBoard.getBoardSize());
	}

	@Test
	public void testMove() throws Exception {
		List<Integer> coordinates = Arrays.asList(0, 1);
		assertEquals(null, board2D.giveBoard(coordinates));
		board2D.move(player, coordinates);
		assertEquals(player, board2D.giveBoard(coordinates));
	}

	@Test(expected = Exception.class)
	public void testWrongMove() throws Exception {
		List<Integer> coordinates = Arrays.asList(0, 1);
		board2D.move(player, coordinates);
		board2D.move(null, coordinates);
	}

	@Test
	public void testWhoWon() throws Exception {
		assertEquals(null, board2D.whoWon());
		board2D.move(player, Arrays.asList(0, 0));
		board2D.move(player, Arrays.asList(0, 1));
		board2D.move(player, Arrays.asList(1, 2));
		assertEquals(null, board2D.whoWon());
		board2D.move(player, Arrays.asList(0, 2));
		assertEquals(player, board2D.whoWon());
	}

	@Test
	public void testWhoWon2() throws Exception {
		assertEquals(null, board2D.whoWon());
		boardSize = 2;
		board2D = new Board2D(boardSize);
		board2D.move(player, Arrays.asList(0, 0));
		assertEquals(null, board2D.whoWon());
		board2D.move(player2, Arrays.asList(1, 1));
		assertEquals(null, board2D.whoWon());
		board2D.move(player, Arrays.asList(1, 0));
		assertEquals(player, board2D.whoWon());
	}

	@Test
	public void testBoardIsFull() throws Exception {
		assertEquals(false, board2D.boardIsFull());
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board2D.move(player, Arrays.asList(i, j));
			}
		}
		assertEquals(true, board2D.boardIsFull());
	}
}