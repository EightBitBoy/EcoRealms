package de.eightbitboy.ecorealms.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
		entities = new MapEntity[sizeX * sizeY];
	}

	public void put(MapEntity entity) {
		if (!hasValidPosition(entity)) {
			//TODO Expect some log output in tests.
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
			notifyListeners();
		} else {
			//FIXME
			// https://www.slf4j.org/manual.html
			// https://stackoverflow.com/questions/1827677/how-to-do-a-junit-assert-on-a-message-in-a-logger
			// http://projects.lidalia.org.uk/slf4j-test/
			Logger logger = LoggerFactory.getLogger(this.getClass());
			logger.debug("This map position is already occupied: " + entity.getPosition());


			//TODO Expect some log output in tests.
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
