package de.eightbitboy.ecorealms.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private static final Logger LOGGER = LoggerFactory.getLogger(Map.class);
	private int sizeX;
	private int sizeY;
	private MapEntity[] entities;
	private List<MapChangeListener> listeners = new ArrayList<MapChangeListener>();

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
		LOGGER.info("Creating a map with the size: " + sizeX + "x/" + sizeY + "y");
		entities = new MapEntity[sizeX * sizeY];
	}

	public void put(MapEntity entity) {
		if (!hasValidPosition(entity)) {
			LOGGER.debug("The entity has an invalid position: " + entity.getPosition());
		} else {
			insert(entity);
		}
	}

	private void insert(MapEntity entity) {
		Position position = entity.getPosition();
		if (isClear(position)) {
			entities[getIndexForPosition(entity.getPosition())] = entity;
			notifyListeners();
		} else {
			LOGGER.debug("This map position is already occupied: " + entity.getPosition());
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

	public void subscribe(MapChangeListener listener) {
		listeners.add(listener);
	}

	private void notifyListeners() {
		for (MapChangeListener listener : listeners) {
			listener.mapChanged();
		}
	}

	public List<MapEntity> getAllEntities() {
		List<MapEntity> e = new ArrayList<MapEntity>();
		for (MapEntity entity : entities) {
			if (entity != null) {
				e.add(entity);
			}
		}
		return e;
	}
}
