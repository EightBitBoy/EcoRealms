package de.eightbitboy.ecorealms.simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	private List<SimulationEntity> entities = new ArrayList<SimulationEntity>();

	public void addEntity(SimulationEntity entity) {
		this.entities.add(entity);
	}

	public void tick() {

	}

	public void tick(float timeDelta) {

	}
}
