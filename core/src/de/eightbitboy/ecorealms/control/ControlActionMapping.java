package de.eightbitboy.ecorealms.control;

import java.util.EnumMap;
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

	private Map<Action, ActionListener> listeners = new EnumMap<Action, ActionListener>(Action.class);

	private ActionInformation actionInformation = new ActionInformation();

	private ControlActionMapping() {
	}

	public static ControlActionMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(Action action, ActionListener listener) {
		//INSTANCE.listeners.add(listener);
	}

	public static ActionInformation getActionInformation() {
		return INSTANCE.actionInformation;
	}

	public void setMousePositionOnMap(Position position) {
		actionInformation.mousePositionOnMap = position;
	}

	void update() {
		actionInformation.reset();
	}
}
