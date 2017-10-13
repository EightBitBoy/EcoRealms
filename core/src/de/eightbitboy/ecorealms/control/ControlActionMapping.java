package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.List;

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

	private List<ActionListener> listeners = new ArrayList<ActionListener>();

	private ActionInformation actionInformation = new ActionInformation();

	private ControlActionMapping() {
	}

	public static ControlActionMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(ActionListener listener) {
		INSTANCE.listeners.add(listener);
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
