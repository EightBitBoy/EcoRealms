package de.eightbitboy.ecorealms.simulation;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Inventory {

	private final Map<Resource, Integer> resources; //TODO Find a better name!?

	public Inventory() {
		resources = new EnumMap<Resource, Integer>(Resource.class);
	}

	public Set<Resource> getResources() {
		return resources.keySet();
	}

	public int get(Resource resource) {
		if (!resources.containsKey(resource)) {
			return 0;
		}
		return resources.get(resource);
	}

	public void add(Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!resources.containsKey(resource)) {
			resources.put(resource, amount);
		} else {
			resources.put(resource, resources.get(resource) + amount);
		}
	}

	public int remove(Resource resource, int amount) {
		checkAmount(resource, amount);

		if (!resources.containsKey(resource)) {
			return 0;
		}

		int currentAmount = resources.get(resource);

		if (amount > currentAmount) {
			resources.put(resource, 0);
			return 0;
		} else {
			resources.put(resource, currentAmount - amount);
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
