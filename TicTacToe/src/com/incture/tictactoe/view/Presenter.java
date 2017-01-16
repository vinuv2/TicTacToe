package com.incture.tictactoe.view;

import java.util.List;

import com.incture.tictactoe.model.BoardAbstract;
import com.incture.tictactoe.model.Player;

public interface Presenter {

	public String welcomeMessage(Player[] players);

	public String displayBoard(BoardAbstract board);

	public List<Integer> getNextInput(Player player);

	public String declaredWinner(Player whoWon, int moveNumber);

	public String printError(Exception e);

	// TODO: Re-factor return obj: <list of input objects>
	public String[][] getPlayersInfo();

	// TODO: Re-factor return obj: <int[0] = dimension, int[1] = boardSize>
	public int[] getBoardInfo();
}