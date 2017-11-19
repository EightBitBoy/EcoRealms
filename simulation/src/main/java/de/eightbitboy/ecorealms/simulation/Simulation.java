package de.eightbitboy.ecorealms.simulation;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.simulation.inventory.InventoryProcessor;
import de.eightbitboy.ecorealms.simulation.production.ProductionDataProcessor;

public class Simulation {
	private List<SimulationMember> members = new ArrayList<SimulationMember>();
	private InventoryProcessor inventoryProcessor;
	private ProductionDataProcessor productionDataProcessor;

	public Simulation() {
		inventoryProcessor = new InventoryProcessor();
		productionDataProcessor = new ProductionDataProcessor();
	}

	public List<SimulationMember> getMembers() {
		return members;
	}

	public void addMember(SimulationMember member) {
		members.add(member);
	}

	public void removeMember(SimulationMember member) {
		members.remove(member);
	}

	public void tick() {

	}

	public void tick(float timeDelta) {

	}
}
