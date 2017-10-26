package de.eightbitboy.ecorealms.simulation;

import java.util.EnumMap;
import java.util.Map;

public class Inventory {

	//TODO Find a better name!?
	public final Map<Resource, Integer> resources = new EnumMap<Resource, Integer>(Resource.class);
}
