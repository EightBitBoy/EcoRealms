package de.eightbitboy.ecorealms.logic;

public class MapTile {
	private final int positionX;
	private final int positionY;

	public MapTile(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
}
