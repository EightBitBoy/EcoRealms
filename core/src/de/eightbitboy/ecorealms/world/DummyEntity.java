package de.eightbitboy.ecorealms.world;

import de.eightbitboy.ecorealms.map.MapEntity;
import de.eightbitboy.ecorealms.map.Position;

public class DummyEntity implements MapEntity {

	private Position position;

	public DummyEntity(Position position) {
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getSizeX() {
		return 1;
	}

	@Override
	public int getSizeY() {
		return 1;
	}

	@Override
	public String toString() {
		return getClass().getName() + position.toString();
	}
}
