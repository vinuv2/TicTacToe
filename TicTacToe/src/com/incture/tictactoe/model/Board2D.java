package com.incture.tictactoe.model;

import java.util.List;

public class Board2D extends BoardAbstract {

	private Player[] playerBoard;
	private int moveCount;

	public Board2D(int boardSize) {
		super(boardSize, 2);
		moveCount = 0;
	}

	@Override
	public int getMoveCount() {
		return moveCount;
	}

	protected Player getPlayerBoard(int index) {
		return playerBoard[index];
	}

	protected void setPlayerBoard(int index, Player player) {
		playerBoard[index] = player;
	}

	@Override
	public void move(Player player, List<Integer> coordinates) throws Exception {
		int index = giveIndex(coordinates);
		if (getPlayerBoard(index) == null) {
			setPlayerBoard(index, player);
			moveCount++;
		} else {
			throw new Exception("Coordinates " + coordinates + " already marked by " + getPlayerBoard(index).getName());
		}
	}

	@Override
	public Player whoWon() {
		int lastIndex = getBoardSize() - 1;
		Player topLeft = getPlayerBoard(getIndex(0, 0));
		Player topRight = getPlayerBoard(getIndex(0, lastIndex));
		Player bottomLeft = getPlayerBoard(getIndex(lastIndex, 0));
		Player bottomRight = getPlayerBoard(getIndex(lastIndex, lastIndex));

		Player p = checkBorders(lastIndex, topLeft, topRight, bottomLeft, bottomRight);
		if (p != null)
			return p;
		p = checkDiagonals(lastIndex, topLeft, topRight, bottomLeft, bottomRight);
		if (p != null)
			return p;
		p = checkHorizontal(lastIndex);
		if (p != null)
			return p;
		return checkVertical(lastIndex);
	}

	private Player checkBorders(int lastIndex, Player topLeft, Player topRight, Player bottomLeft, Player bottomRight) {
		// Top Border, Left Border, Right Border, Bottom Border
		boolean topFlag = (topLeft != null && topLeft == getPlayerBoard(getIndex(0, lastIndex)));
		boolean leftFlag = (topLeft != null && topLeft == getPlayerBoard(getIndex(lastIndex, 0)));
		boolean rightFlag = (bottomRight != null && bottomRight == getPlayerBoard(getIndex(0, lastIndex)));
		boolean bottomFlag = (bottomRight != null && bottomRight == getPlayerBoard(getIndex(lastIndex, 0)));
		for (int i = 1; (topFlag || leftFlag || rightFlag || bottomFlag) && i < lastIndex; i++) {
			topFlag &= (topLeft == getPlayerBoard(getIndex(0, i)));
			leftFlag &= (topLeft == getPlayerBoard(getIndex(i, 0)));
			rightFlag &= (topRight == getPlayerBoard(getIndex(i, lastIndex)));
			bottomFlag &= (bottomLeft == getPlayerBoard(getIndex(lastIndex, i)));
		}
		return topFlag || leftFlag ? topLeft : (rightFlag || bottomFlag ? bottomRight : null);
	}

	private Player checkDiagonals(int lastIndex, Player topLeft, Player topRight, Player bottomLeft,
			Player bottomRight) {
		boolean backSlashFlag = (topLeft != null && topLeft == bottomRight);
		boolean frontSlashFlag = (topRight != null && topRight == bottomLeft);
		for (int i = 1; (backSlashFlag || frontSlashFlag) && i < lastIndex; i++) {
			backSlashFlag &= (topLeft == getPlayerBoard(getIndex(i, i)));
			frontSlashFlag &= (topRight == getPlayerBoard(getIndex(i, lastIndex - i)));
		}
		return backSlashFlag ? topLeft : (frontSlashFlag ? bottomRight : null);
	}

	private Player checkHorizontal(int lastIndex) {
		for (int i = 1; i < lastIndex; i++) {
			Player pos1 = getPlayerBoard(getIndex(i, 0));
			boolean horizontal = (pos1 != null && pos1 == getPlayerBoard(getIndex(i, lastIndex)));
			for (int j = 1; horizontal && j < lastIndex; j++) {
				horizontal &= (pos1 == getPlayerBoard(getIndex(i, j)));
			}
			if (horizontal) {
				return pos1;
			}
		}
		return null;
	}

	private Player checkVertical(int lastIndex) {
		for (int i = 1; i < lastIndex; i++) {
			Player pos1 = getPlayerBoard(getIndex(0, i));
			boolean vertical = (pos1 != null && pos1 == getPlayerBoard(getIndex(lastIndex, i)));
			for (int j = 1; vertical && j < lastIndex; j++) {
				vertical &= (pos1 == getPlayerBoard(getIndex(j, i)));
			}
			if (vertical) {
				return pos1;
			}
		}
		return null;
	}

	@Override
	public boolean boardIsFull() {
		boolean flag = true;
		int maxLength = getMaxLength();
		for (int i = 0; flag && i < maxLength; i++) {
			flag &= (getPlayerBoard(i) != null);
		}
		return flag;
	}

	@Override
	public Player giveBoard(List<Integer> coordinates) throws Exception {
		return getPlayerBoard(giveIndex(coordinates));
	}

	protected int giveIndex(List<Integer> coordinates) throws Exception {
		validateCoordinates(coordinates);
		Integer i = coordinates.get(0);
		Integer j = coordinates.get(1);
		return getIndex(i, j);
	}

	private int getIndex(Integer i, Integer j) {
		return i * getBoardSize() + j;
	}

	@Override
	protected void initializePlayerBoard() {
		int maxLength = getMaxLength();
		playerBoard = new Player[maxLength];
	}

	private int getMaxLength() {
		int maxLength = getBoardSize();
		int dimension = getDimension();
		while (--dimension > 0) {
			maxLength *= getBoardSize();
		}
		return maxLength;
	}
}