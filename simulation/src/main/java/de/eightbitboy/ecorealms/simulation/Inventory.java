package de.eightbitboy.ecorealms.simulation;

import java.util.EnumMap;
import java.util.Map;

public class Inventory {

	private Map<Resource, Integer> resources; //TODO Find a better name!?

	public Inventory() {
		resources = new EnumMap<Resource, Integer>(Resource.class);
	}

	public void add(Resource resource, int amount) {

	}

	public int get(Resource resource) {
		return 0;
	}

	public int remove(Resource resource, int amount) {
		return 0;
	}
}
