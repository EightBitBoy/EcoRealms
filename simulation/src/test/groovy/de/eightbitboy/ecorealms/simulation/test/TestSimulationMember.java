package de.eightbitboy.ecorealms.simulation.test;

import de.eightbitboy.ecorealms.simulation.SimulationMember;
import de.eightbitboy.ecorealms.simulation.inventory.Inventory;
import de.eightbitboy.ecorealms.simulation.production.ProducerData;

public class TestSimulationMember implements SimulationMember {

	private Inventory inventory;
	private ProducerData producerData;

	TestSimulationMember() {
		inventory = new Inventory();
		producerData = new ProducerData();
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public ProducerData getProducerData() {
		return producerData;
	}
}
