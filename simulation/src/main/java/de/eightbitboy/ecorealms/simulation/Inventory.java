package de.eightbitboy.ecorealms.simulation;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Inventory {

	private Map<Resource, Integer> resources; //TODO Find a better name!?

	public Inventory() {
		resources = new EnumMap<Resource, Integer>(Resource.class);
	}

	public Set<Resource> getResources() {
		return resources.keySet();
	}

	public void add(Resource resource, int amount) {
		//TODO
	}

	public int get(Resource resource) {
		return 0; //TODO
	}

	public int remove(Resource resource, int amount) {
		return 0; //TODO
	}
}
