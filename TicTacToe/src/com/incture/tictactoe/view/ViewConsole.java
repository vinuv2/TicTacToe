package com.incture.tictactoe.view;

import java.util.Scanner;

public class ViewConsole implements View {

	private Scanner scanner;

	public ViewConsole() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		scanner.close();
	}

	@Override
	public int nextInt() {
		return scanner.nextInt();
	}

	@Override
	public String nextString() {
		return scanner.next();
	}
}