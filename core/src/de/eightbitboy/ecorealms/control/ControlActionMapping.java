package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import de.eightbitboy.ecorealms.map.Position;

public class ControlActionMapping {

	public interface ActionListener {
		void action(Action action);
	}

	private static final ControlActionMapping INSTANCE = new ControlActionMapping();
	private Map<Action, List<ActionListener>> listeners;
	private ActionInformation actionInformation = new ActionInformation();

	private ControlActionMapping() {
		listeners = new EnumMap<Action, List<ActionListener>>(Action.class);
		for (Action action : Action.values()) {
			listeners.put(action, new ArrayList<ActionListener>());
		}
	}

	public static ControlActionMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(Action action, ActionListener listener) {
		INSTANCE.listeners.get(action).add(listener);
	}

	static ActionInformation getActionInformation() {
		return INSTANCE.actionInformation;
	}

	void setClickPositionOnMap(Position position) {
		actionInformation.clickPositionOnMap = position;
	}

	void setHoverPositionOnMap(Position position) {
		actionInformation.hoverPositionOnMap = position;
	}

	void fire(Action action) {
		for (ActionListener listener : listeners.get(action)) {
			listener.action(action);
		}
	}

	public void update() {
		fire(Action.UPDATE);
		actionInformation.reset();
	}
}
