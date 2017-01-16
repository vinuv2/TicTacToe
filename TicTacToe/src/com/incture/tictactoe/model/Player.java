package com.incture.tictactoe.model;

public final class Player {
	private String name;
	private Character mark;

	public Player(String name, char mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public char getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		return mark.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) ? true : (obj == null ? false : (this.hashCode() == obj.hashCode()));
	}
}
