package com.incture.tictactoe.model;

import java.util.List;

public abstract class BoardAbstract {

	private final int boardSize;
	private final int dimension;

	public BoardAbstract(int boardSize, int dimension) {
		this.boardSize = boardSize;
		this.dimension = dimension;
		initializePlayerBoard();
	}

	public int getBoardSize() {
		return boardSize;
	}

	public int getDimension() {
		return dimension;
	}

	public abstract Player whoWon();

	public abstract boolean boardIsFull();

	public abstract void move(Player player, List<Integer> coordinates) throws Exception;

	public abstract Player giveBoard(List<Integer> coordinates) throws Exception;

	protected abstract void initializePlayerBoard();

	protected abstract int giveIndex(List<Integer> list) throws Exception;

	protected void validateCoordinates(List<Integer> coordinates) throws Exception {
		if (coordinates == null || coordinates.size() != dimension) {
			throw new Exception("Invalid Dimensions:" + coordinates);
		}
		for (Integer integer : coordinates) {
			if (integer >= boardSize) {
				throw new Exception("Invalid Indexes:" + coordinates);
			}
		}
	}

	public abstract int getMoveCount();
}