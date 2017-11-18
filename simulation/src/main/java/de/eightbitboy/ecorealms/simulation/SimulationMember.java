package de.eightbitboy.ecorealms.simulation;

import de.eightbitboy.ecorealms.simulation.inventory.Inventory;
import de.eightbitboy.ecorealms.simulation.production.ProductionData;

public interface SimulationMember {

	public Inventory getInventory();

	public ProductionData getProductionData();
}
