package de.eightbitboy.ecorealms.world;

public class World {
	private int sizeX;
	private int sizeY;

	private WorldTile[] worldTiles;

	public World(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.worldTiles = new WorldTile[sizeX * sizeY];

		generateMap();
	}

	private void generateMap() {
		int counter = 0;
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				worldTiles[counter] = new WorldTile();
				counter++;
			}
		}
	}

	public WorldTile[] getWorldTiles() {
		return worldTiles;
	}
}
