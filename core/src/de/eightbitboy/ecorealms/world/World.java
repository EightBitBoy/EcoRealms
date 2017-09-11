package de.eightbitboy.ecorealms.world;

public class World {
	private int sizeX;
	private int sizeY;

	private Tile[] tiles;

	public World(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.tiles = new Tile[sizeX * sizeY];

		generateMap();
	}

	private void generateMap() {
		int counter = 0;
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				tiles[counter] = new Tile();
				counter++;
			}
		}
	}

	public Tile[] getTiles() {
		return tiles;
	}
}
