package test.incture.tictactoe.view;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class Presenter2DTest {

	// private View view;
	// private Presenter2D presenter;
	// private Player player1;
	// private Player player2;
	//
	// private void setUp(String source) {
	// view = new ViewMockString(source);
	// presenter = new Presenter2D(view);
	// player1 = new Player("Joe", 'X');
	// player2 = new Player("Lis", '0');
	// }
	//
	// @Test
	// public void testDisplayBoard() throws Exception {
	// String source = "";
	// setUp(source);
	// BoardAbstract board = new Board2D(2); // This can be Mocked
	// assertEquals(" | \n | ", presenter.displayBoard(board));
	// board.move(player1, Arrays.asList(0, 0));
	// board.move(player2, Arrays.asList(1, 1));
	// board.move(player1, Arrays.asList(1, 0));
	// assertEquals("X| \nX|0", presenter.displayBoard(board));
	// }
	//
	// @Test // Scanner part must be mocked, else this is a manual test
	// public void testGetNextInput() {
	// String source = "1 2";
	// setUp(source);
	// assertEquals(Arrays.asList(1, 2), presenter.getNextInput(player1));
	// }
	//
	// @Test
	// public void testDeclaredWinner() {
	// String source = "";
	// setUp(source);
	// int moveNumber = 10;
	// assertEquals("It's a draw", presenter.declaredWinner(null, moveNumber));
	// assertEquals("Joe wins the game in 10 moves",
	// presenter.declaredWinner(player1, moveNumber));
	// assertEquals("Lis wins the game in 10 moves",
	// presenter.declaredWinner(player2, moveNumber));
	// }
	//
	// @Test
	// public void testWelcomeMessage() {
	// String source = "";
	// setUp(source);
	// Player[] players = new Player[2];
	// players[0] = player1;
	// players[1] = player2;
	// assertEquals("Welcome Joe & Lis to this game of tic-tac-toe!",
	// presenter.welcomeMessage(players));
	//
	// Player[] players2 = new Player[3];
	// players2[0] = player1;
	// players2[1] = player2;
	// players2[2] = new Player("Tom", '+');
	// assertEquals("Welcome Joe, Lis & Tom to this game of tic-tac-toe!",
	// presenter.welcomeMessage(players2));
	// }
	//
	// @Test
	// public void testPrintError() {
	// String source = "";
	// setUp(source);
	// String message = "This is a test";
	// Exception e = new Exception(message);
	// assertEquals(message, presenter.printError(e));
	//
	// }
	//
	// @Test // Scanner part must be mocked, else this is a manual test
	// public void testMakePlayers() {
	// String[][] strs = new String[3][2];
	// strs[0][0] = "Joe";
	// strs[0][1] = "X";
	// strs[1][0] = "Lis";
	// strs[1][1] = "0";
	// strs[2][0] = "Tom";
	// strs[2][1] = "T";
	//
	// String source = "2 Joe X Lis 0 ";
	// setUp(source);
	// String[][] playersInfo = presenter.getPlayersInfo();
	// for (int i = 0; i < 2; i++) {
	// Assert.assertArrayEquals(strs[i], playersInfo[i]);
	// }
	//
	// String source2 = "3 Joe X Lis 0 Tom T";
	// setUp(source2);
	// String[][] playersInfo2 = presenter.getPlayersInfo();
	// for (int i = 0; i < 2; i++) {
	// Assert.assertArrayEquals(strs[i], playersInfo2[i]);
	// }
	// }
	//
	// @Test
	// public void testMakeBoard() {
	// String source = "2 3";
	// setUp(source);
	// int[] arr = new int[2];
	// arr[0] = 2;
	// arr[1] = 3;
	// Assert.assertArrayEquals(arr, presenter.getBoardInfo());
	// }

	@Test
	public void sortList() {
		SortedSet<Dto> list = buildList();
		Dto[] dtos = new Dto[list.size()];
		System.out.println(list);
		dtos = list.toArray(dtos);
		Arrays.sort(dtos); // ??
		
		System.out.println(Arrays.asList(dtos));
		// TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		// for (int i = 0; i < 10; i++) {
		// map.put(i, "value" + i);
		// }
		// TreeMap<Integer, String> map2 = new TreeMap<Integer, String>();
		// map2.put(8, "value8");
		// map2.put(9, "value9");
		// assertEquals(map2, map.tailMap(8));
		// map = (TreeMap<Integer, String>) map.headMap(8);
	}

	@SuppressWarnings("deprecation")
	private SortedSet<Dto> buildList() {
		SortedSet<Dto> list = new TreeSet<Dto>();
		for (int i = 19; i >= 0; i--) {
			list.add(new Dto("requestType" + i, new Date(2014, 12, i)));
		}
		return list;
	}

}

class Dto implements Comparable<Dto> {
	String requestType;
	Date requestDate;
	int count;

	protected int getCount() {
		return count;
	}

	protected void setCount(int count) {
		this.count = count;
	}

	public Dto(String requestType, Date requestDate) {
		super();
		this.requestType = requestType;
		this.requestDate = requestDate;
	}

	protected String getRequestType() {
		return requestType;
	}

	protected void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	protected Date getRequestDate() {
		return requestDate;
	}

	protected void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Override
	public int compareTo(Dto o) {
		// TODO: Handle null case later
		return this.requestDate.compareTo(o.requestDate);
	}

	@Override
	public String toString() {
		SimpleDateFormat sf = new SimpleDateFormat("yy/mm/dd");
		return "Dto [requestType=" + requestType + ", requestDate=" + sf.format(requestDate) + "]";
	}
}