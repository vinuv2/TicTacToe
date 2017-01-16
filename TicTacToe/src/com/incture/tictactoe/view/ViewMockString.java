package com.incture.tictactoe.view;

import java.util.Scanner;

public class ViewMockString implements View {

	private Scanner sc;

	public ViewMockString(String source) {
		sc = new Scanner(source);
	}

	@Override
	public void print(String message) {
		System.out.println("Called");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (sc != null)
			sc.close();
	}

	@Override
	public int nextInt() {
		return sc.nextInt();
	}

	@Override
	public String nextString() {
		return sc.next();
	}
}
