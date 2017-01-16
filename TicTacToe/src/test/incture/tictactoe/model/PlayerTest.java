package test.incture.tictactoe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.incture.tictactoe.model.Player;

public class PlayerTest {

	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player("Joe", 'X');
	}

	@Test
	public void testHashCode() {
		assertEquals(player.hashCode(), 'X');
	}

	@Test
	public void testPlayer() {
		Player player2 = new Player("Joe2", 'X');
		assertTrue(player.equals(player2));
		Set<Player> set = new HashSet<Player>(2);
		set.add(player);
		set.add(player2);
		assertEquals(set.size(), 1);
	}

	@Test
	public void testGetName() {
		assertEquals(player.getName(), "Joe");
	}

	@Test
	public void testGetMark() {
		assertEquals(player.getMark(), 'X');
	}

	@Test
	public void testPlayersAndInstances() {
		char mark1 = 'X';
		Player playerA = new Player("John", mark1);
		assertEquals(mark1, playerA.getMark());
		assertEquals("John", playerA.getName());

		char mark2 = '0';
		Player playerB = new Player("Lis", mark2);
		assertEquals(mark2, playerB.getMark());
		assertEquals("Lis", playerB.getName());

		assertNotEquals(mark1, playerB.getMark());
		assertNotEquals("John", playerB.getName());
		// Player playerC = new Player("Bob", Mark.X);

	}
}