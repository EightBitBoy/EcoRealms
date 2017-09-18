package de.eightbitboy.ecorealms.logic;

public class Map {
	private int sizeX;
	private int sizeY;

	public Map(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		generateMap();
	}

	private void generateMap() {
		int counter = 0;
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				counter++;
			}
		}
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
}
