package de.eightbitboy.ecorealms.map;

public class Map {
	private int sizeX;
	private int sizeY;

	public Map(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		initialize();
	}

	private void initialize() {

	}

	public void put(MapEntity entity) {

	}

	public MapEntity get(MapPoint position) {
		//TODO
		return new MapEntity() {
			@Override
			public MapPoint getPosition() {
				return null;
			}

			@Override
			public int getSizeX() {
				return 0;
			}

			@Override
			public int getSizeY() {
				return 0;
			}
		};
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
}
