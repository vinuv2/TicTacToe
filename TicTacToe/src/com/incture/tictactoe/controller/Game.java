package com.incture.tictactoe.controller;

import java.util.HashSet;
import java.util.Set;

import com.incture.tictactoe.model.Board2D;
import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;
import com.incture.tictactoe.view.Presenter;

/**
 * Add a comment
 * @author VINU
 *
 */
public class Game {

	private void assertParams(BoardAbstract board, Player[] players, Presenter presenter) {
		assert board != null : "Board cannot be null";
		assert players != null : "Players cannot be null";
		assert presenter != null : "Presenter cannot be null";
	}

	public boolean run(BoardAbstract board, Player[] players, Presenter presenter) {
		assertParams(board, players, presenter);
		int playersSize = players.length;
		presenter.welcomeMessage(players);
		boolean boardIsFull = false;
		boolean noPlayerWon = true;
		while (!boardIsFull && noPlayerWon) {
			Player player = players[board.getMoveCount() % playersSize];
			try {
				board.move(player, presenter.getNextInput(player));
			} catch (Exception e) {
				presenter.printError(e);
				e.printStackTrace();
				return false;
			}
			boardIsFull = board.boardIsFull();
			noPlayerWon = board.whoWon() == null;
		}
		presenter.declaredWinner(board.whoWon(), board.getMoveCount());
		return true;
	}

	public Player[] makePlayers(Presenter presenter) {
		Set<Player> playerArgs = null;
		String[][] playerInputs = null;
		playerInputs = presenter.getPlayersInfo();
		playerArgs = new HashSet<Player>(playerInputs.length);
		for (int i = 0; i < playerInputs.length; i++) {
			if (!playerArgs.add(new Player(playerInputs[i][0], playerInputs[i][1].charAt(0)))) {
				presenter.printError(new Exception("Player's marks must be unique"));
				makePlayers(presenter);// REDO
			}
		}
		Player[] players = new Player[playerArgs.size()];
		return playerArgs.toArray(players);
	}

	public BoardAbstract makeBoard(Presenter presenter) {
		int[] boardFacts = presenter.getBoardInfo();
		assert boardFacts[0] == 2 : "Only 2D implemented";
		return new Board2D(boardFacts[1]);
	}
}