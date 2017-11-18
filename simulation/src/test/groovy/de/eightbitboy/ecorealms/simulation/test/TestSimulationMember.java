package de.eightbitboy.ecorealms.simulation.test;

import de.eightbitboy.ecorealms.simulation.SimulationMember;
import de.eightbitboy.ecorealms.simulation.inventory.Inventory;
import de.eightbitboy.ecorealms.simulation.production.ProductionData;

public class TestSimulationMember implements SimulationMember {

	private Inventory inventory;
	private ProductionData productionData;

	TestSimulationMember() {
		inventory = new Inventory();
		productionData = new ProductionData();
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public ProductionData getProductionData() {
		return productionData;
	}
}
