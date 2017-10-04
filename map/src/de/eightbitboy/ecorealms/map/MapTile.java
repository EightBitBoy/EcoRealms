package de.eightbitboy.ecorealms.map;

public class MapTile {

	public enum Type {
		GROUND, SEA
	}

	private final int positionX;
	private final int positionY;
	private final Type type;

	public MapTile(int positionX, int positionY, Type type) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.type = type;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Type getType() {
		return type;
	}
}
