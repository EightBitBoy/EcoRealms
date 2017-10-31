package de.eightbitboy.ecorealms.simulation.inventory;

import java.util.Set;
import java.util.stream.Collectors;

import de.eightbitboy.ecorealms.simulation.resource.Resource;

public class InventoryProcessor {

	public Set<Resource> getResources(Inventory inventory) {
		return inventory.items.keySet().stream()
				.filter(resource -> inventory.items.get(resource) != 0)
				.collect(Collectors.toSet());
	}

	public int get(Inventory inventory, Resource resource) {
		if (!inventory.items.containsKey(resource)) {
			return 0;
		}
		return inventory.items.get(resource);
	}

	public void add(Inventory inventory, Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!inventory.items.containsKey(resource)) {
			inventory.items.put(resource, amount);
		} else {
			inventory.items.put(resource, inventory.items.get(resource) + amount);
		}
	}

	public int remove(Inventory inventory, Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!inventory.items.containsKey(resource)) {
			return 0;
		}

		int currentAmount = inventory.items.get(resource);

		if (amount > currentAmount) {
			inventory.items.put(resource, 0);
			return currentAmount;
		} else {
			inventory.items.put(resource, currentAmount - amount);
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
