package de.eightbitboy.ecorealms.simulation.inventory;

import java.util.Set;
import java.util.stream.Collectors;

import de.eightbitboy.ecorealms.simulation.Resource;

//TODO Find an alternative to "Processor". An inventory is not "processed"!
public class InventoryProcessor {

	public Set<Resource> getResources(de.eightbitboy.ecorealms.simulation.inventory.Inventory inventory) {
		return inventory.resources.keySet().stream()
				.filter(resource -> inventory.resources.get(resource) != 0)
				.collect(Collectors.toSet());
	}

	public int get(de.eightbitboy.ecorealms.simulation.inventory.Inventory inventory, Resource resource) {
		if (!inventory.resources.containsKey(resource)) {
			return 0;
		}
		return inventory.resources.get(resource);
	}

	public void add(de.eightbitboy.ecorealms.simulation.inventory.Inventory inventory, Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!inventory.resources.containsKey(resource)) {
			inventory.resources.put(resource, amount);
		} else {
			inventory.resources.put(resource, inventory.resources.get(resource) + amount);
		}
	}

	public int remove(de.eightbitboy.ecorealms.simulation.inventory.Inventory inventory, Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!inventory.resources.containsKey(resource)) {
			return 0;
		}

		int currentAmount = inventory.resources.get(resource);

		if (amount > currentAmount) {
			inventory.resources.put(resource, 0);
			return currentAmount;
		} else {
			inventory.resources.put(resource, currentAmount - amount);
			return amount;
		}
	}

	private void checkAmount(Resource resource, int amount) {
		if (amount < 0) {
			throw new RuntimeException("The resource amount is negative! "
					+ resource.name() + ": " + amount);
		}
	}
}
