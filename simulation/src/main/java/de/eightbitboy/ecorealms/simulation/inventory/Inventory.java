package de.eightbitboy.ecorealms.simulation.inventory;

import java.util.EnumMap;
import java.util.Map;

import de.eightbitboy.ecorealms.simulation.resource.Resource;

public class Inventory {

	public final Map<Resource, Integer> items = new EnumMap<Resource, Integer>(Resource.class);
}
