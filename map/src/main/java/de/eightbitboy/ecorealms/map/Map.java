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
			//TODO Rather log this information!
			/*
			throw new InvalidMapAccessException(
					"The entity has an invalid position: " + entity.getPosition());
					*/
		} else {
			insert(entity);
		}
	}

	private void insert(MapEntity entity) {
		Position position = entity.getPosition();
		if (isClear(position)) {
			entities[getIndexForPosition(entity.getPosition())] = entity;
		} else {
			//TODO Rather log this information!
			/*
			throw new InvalidMapAccessException(
					"The position is already occupied: " + entity.getPosition());
					*/
		}
	}

	/**
	 * The y-values are stored next to each other.
	 */
	private int getIndexForPosition(Position position) {
		return ((position.x % sizeX) * sizeY) + position.y;
	}

	public MapEntity get(Position position) {
		return entities[getIndexForPosition(position)];
	}

	public void remove(MapEntity entity) {
		entities[getIndexForPosition(entity.getPosition())] = null;
	}

	private boolean hasValidPosition(MapEntity entity) {
		Position position = entity.getPosition();

		return !(position.x < 0 ||
				position.y < 0 ||
				position.x >= this.sizeX ||
				position.y >= this.sizeY);
	}

	boolean isClear(Position position) {
		return entities[getIndexForPosition(position)] == null;
	}
}
