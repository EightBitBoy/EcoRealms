package de.eightbitboy.ecorealms.simulation;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.simulation.inventory.InventoryProcessor;
import de.eightbitboy.ecorealms.simulation.production.ProductionDataProcessor;

public class Simulation {

	private static final float TICKS_PER_SECOND = 5;
	private static final float MILLIS_PER_TICK = 1000 / TICKS_PER_SECOND;

	private float extraMillisFromLastTick = 0;
	private int tickCount = 0;

	private List<SimulationMember> members = new ArrayList<SimulationMember>();
	private InventoryProcessor inventoryProcessor;
	private ProductionDataProcessor productionDataProcessor;

	public Simulation() {
		inventoryProcessor = new InventoryProcessor();
		productionDataProcessor = new ProductionDataProcessor();
	}

	public int getTickCount() {
		return tickCount;
	}

	public List<SimulationMember> getMembers() {
		return members;
	}

	public void addMember(SimulationMember member) {
		members.add(member);
	}

	public void removeMember(SimulationMember member) {
		members.remove(member);
	}

	public void tick() {
		tickCount++;
	}

	public float tickWithDelta(float timeDeltaMillis) {
		timeDeltaMillis += extraMillisFromLastTick;

		while (timeDeltaMillis >= MILLIS_PER_TICK) {
			timeDeltaMillis -= MILLIS_PER_TICK;
			tick();
		}

		extraMillisFromLastTick = timeDeltaMillis;
		return extraMillisFromLastTick;
	}
}
