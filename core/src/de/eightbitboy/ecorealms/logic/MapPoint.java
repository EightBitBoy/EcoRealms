package de.eightbitboy.ecorealms.logic;

public class MapPoint {
	private int x;
	private int y;

	public MapPoint() {
		this.x = 0;
		this.y = 0;
	}

	public MapPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
