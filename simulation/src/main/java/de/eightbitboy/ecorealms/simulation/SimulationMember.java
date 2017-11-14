package de.eightbitboy.ecorealms.simulation;

import de.eightbitboy.ecorealms.simulation.inventory.Inventory;
import de.eightbitboy.ecorealms.simulation.production.ProducerData;

public interface SimulationMember {

	public Inventory getInventory();

	public ProducerData getProducerData();
}
