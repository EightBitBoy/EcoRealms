package de.eightbitboy.ecorealms.world.entity;

import de.eightbitboy.ecorealms.map.MapEntity;
import de.eightbitboy.ecorealms.map.Position;

public class BaseMapEntity implements MapEntity {
	private Position position;

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getSizeX() {
		return 0;
	}

	@Override
	public int getSizeY() {
		return 0;
	}
}
