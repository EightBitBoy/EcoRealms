package de.eightbitboy.ecorealms.simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

	private List<SimulationMember> members = new ArrayList<SimulationMember>();

	public void addEntity(SimulationMember member) {
		members.add(member);
	}

	public void removeEntity(SimulationMember member) {
		members.remove(member);
	}

	public void tick() {

	}

	public void tick(float timeDelta) {

	}
}
