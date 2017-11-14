package de.eightbitboy.ecorealms.simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	private List<SimulationMember> entities = new ArrayList<SimulationMember>();

	public void addEntity(SimulationMember entity) {
		this.entities.add(entity);
	}

	public void removeEntity(SimulationMember entity) {

	}

	public void tick() {

	}

	public void tick(float timeDelta) {

	}
}
