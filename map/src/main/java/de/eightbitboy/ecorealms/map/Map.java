package de.eightbitboy.ecorealms.map;

public class Map {
	private int sizeX;
	private int sizeY;
	private MapEntity[] entities;

	public Map(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		initialize();
	}

	private void initialize() {
	}

	public void put(MapEntity entity) {
		if (!hasValidPosition(entity)) {
			throw new InvalidMapAccessException("The entity has an invalid position: "
					+ entity.getPosition().toString());
		}
	}

	private boolean hasValidPosition(MapEntity entity) {
		MapPoint position = entity.getPosition();

		return !(position.x < 0 ||
				position.y < 0 ||
				position.x >= this.sizeX ||
				position.y >= this.sizeY);
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
