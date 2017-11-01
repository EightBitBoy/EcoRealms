package de.eightbitboy.ecorealms.simulation.production;

import java.util.HashMap;
import java.util.Map;

import de.eightbitboy.ecorealms.simulation.resource.Resource;

public class ProducerData {

	public final Map<Resource, Integer> input = new HashMap<Resource, Integer>();

	public final Map<Resource, Integer> output = new HashMap<Resource, Integer>();
}
