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


	public int getSizeX() {
		return this.sizeX;
	}

	public int getSizeY() {
		return this.sizeY;
	}

	MapEntity[] getEntities() {
		return this.entities;
	}

	private void initialize() {
		entities = new MapEntity[sizeX * sizeY];
	}

	public void put(MapEntity entity) {
		if (!hasValidPosition(entity)) {
			throw new InvalidMapAccessException(
					"The entity has an invalid position: " + entity.getPosition().toString());
		} else {
			insert(entity);
		}
	}

	private void insert(MapEntity entity) {

	}

	public void remove(MapEntity entity) {
		
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
}
