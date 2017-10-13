package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import de.eightbitboy.ecorealms.map.Position;

public class ControlActionMapping {

	public enum Action {
		LMB,
		RMB;

		public ActionInformation info() {
			return ControlActionMapping.getActionInformation();
		}
	}

	public class ActionInformation {
		public Position mousePositionOnMap = new Position(0, 0);

		void reset() {
			mousePositionOnMap = new Position(0, 0);
		}
	}

	public interface ActionListener {
		void action(Action action);
	}

	private static final ControlActionMapping INSTANCE = new ControlActionMapping();

	//TODO Use a set for listeners?
	private Map<Action, List<ActionListener>> listeners;

	private ActionInformation actionInformation;

	private ControlActionMapping() {
		listeners = new EnumMap<Action, List<ActionListener>>(Action.class);
		for (Action action : Action.values()) {
			listeners.put(action, new ArrayList<ActionListener>());
		}

		actionInformation = new ActionInformation();
	}

	public static ControlActionMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(Action action, ActionListener listener) {
		INSTANCE.listeners.get(action).add(listener);
	}

	public static ActionInformation getActionInformation() {
		return INSTANCE.actionInformation;
	}

	public void setMousePositionOnMap(Position position) {
		actionInformation.mousePositionOnMap = position;
	}

	public void fire(Action action) {
		for (ActionListener listener : listeners.get(action)) {
			listener.action(action);
		}
	}

	public void update() {
		actionInformation.reset();
	}
}
