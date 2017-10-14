package de.eightbitboy.ecorealms.control;

import de.eightbitboy.ecorealms.map.Position;

public class ActionInformation {
	public Position clickPositionOnMap = new Position(0, 0);
	public Position hoverPositionOnMap = new Position(0, 0);

	void reset() {
		clickPositionOnMap = new Position(0, 0);
	}
}
