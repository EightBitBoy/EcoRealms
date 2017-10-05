package de.eightbitboy.ecorealms.map;

public class MapPoint {
	public final int x;
	public final int y;

	public MapPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
