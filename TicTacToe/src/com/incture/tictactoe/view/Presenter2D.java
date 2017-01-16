package com.incture.tictactoe.view;

import java.util.Arrays;
import java.util.List;

import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;

public class Presenter2D implements Presenter {

	private View view;

	public Presenter2D(View view) {
		assert view != null : "View cannot be null";
		this.view = view;
	}

	@Override
	public String displayBoard(BoardAbstract board) {
		StringBuilder sb = new StringBuilder();
		int boardSize = board.getBoardSize();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Player tile = null;
				try {
					tile = board.giveBoard(Arrays.asList(i, j));
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (tile == null)
					sb.append(' ');
				else
					sb.append(tile.getMark());
				if (j < boardSize - 1)
					sb.append("|");
			}
			if (i < boardSize - 1)
				sb.append("\n");
		}
		print(sb.toString());
		return sb.toString();
	}

	private void print(String message) {
		view.print(message);
	}

	@Override
	public List<Integer> getNextInput(Player player) {
		print("Next move by " + player.getName() + " enter coordinates:");
		int i = view.nextInt();
		int j = view.nextInt();
		return Arrays.asList(i, j);
	}

	@Override
	public String declaredWinner(Player whoWon, int moveNumber) {
		StringBuilder sb = new StringBuilder();
		if (whoWon == null) {
			sb.append("It's a draw");
		} else {
			sb.append(whoWon.getName());
			sb.append(" wins the game in ");
			sb.append(moveNumber);
			sb.append(" moves");
		}
		print(sb.toString());
		return sb.toString();
	}

	@Override
	public String printError(Exception e) {
		print(e.getMessage());
		return e.getMessage();
	}

	@Override
	public String welcomeMessage(Player[] players) {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome ");
		if (players[0] != null)
			sb.append(players[0].getName());
		for (int i = 1; i < players.length; i++) {
			if (players[i] == null)
				continue;
			if (i < players.length - 1) {
				sb.append(", ");
			} else {
				sb.append(" & ");
			}
			sb.append(players[i].getName());
		}
		sb.append(" to this game of tic-tac-toe!");
		return sb.toString();
	}

	@Override
	public String[][] getPlayersInfo() {
		print("Number of Players?:");
		int numberOfPlayer = view.nextInt();
		String[][] result = new String[numberOfPlayer][2];
		for (int nth = 1; nth <= numberOfPlayer; nth++) {
			print("Player " + nth + " Name:");
			String name = view.nextString();
			print("Player " + nth + " Mark:");
			String mark = view.nextString();
			result[nth - 1][0] = name;
			result[nth - 1][1] = mark;
		}
		return result;
	}

	@Override // Hard coded
	public int[] getBoardInfo() {
		print("Enter Dimension and BoardSize:");
		int[] boardFacts = new int[2];
		boardFacts[0] = view.nextInt(); // 2-Dimensional
		boardFacts[1] = view.nextInt(); // 3X3
		return boardFacts;
	}
}