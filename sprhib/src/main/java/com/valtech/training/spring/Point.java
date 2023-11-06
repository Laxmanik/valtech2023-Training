package com.valtech.training.spring;

public class Point {

	private int x;
	private int y;
	
	
	
	public Point() {
		System.out.println("Parameterless Constructor...");
	}
	
	public Point(int x, int y) {
		System.out.println("Parameterised Constructor...");
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
