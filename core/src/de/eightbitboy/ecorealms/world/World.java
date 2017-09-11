package de.eightbitboy.ecorealms.world;

public class World {
	private int sizeX;
	private int sizyY;

	private Tile[] tiles;

	public World(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizyY = sizeY;
		this.tiles = new Tile[sizeX * sizeY];

		generateMap();
	}

	private void generateMap() {
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizyY; y++) {
				tiles[x * y] = new Tile();
			}
		}
	}

	public Tile[] getTiles() {
		return tiles;
	}
}
