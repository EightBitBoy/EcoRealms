package de.eightbitboy.ecorealms.simulation.inventory;

import java.util.EnumMap;
import java.util.Map;

import de.eightbitboy.ecorealms.simulation.Resource;

public class Inventory {

	//TODO Find a better name!?
	public final Map<Resource, Integer> resources = new EnumMap<Resource, Integer>(Resource.class);
}
