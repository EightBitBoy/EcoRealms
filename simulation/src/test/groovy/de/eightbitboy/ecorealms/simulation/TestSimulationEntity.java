package de.eightbitboy.ecorealms.simulation;

import de.eightbitboy.ecorealms.simulation.inventory.Inventory;
import de.eightbitboy.ecorealms.simulation.production.ProducerData;

public class TestSimulationEntity implements SimulationEntity {
	@Override
	public Inventory getInventory() {
		return null;
	}

	@Override
	public ProducerData getProducerData() {
		return null;
	}
}
