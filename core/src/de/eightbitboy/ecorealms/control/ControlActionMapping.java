package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.List;

public class ControlActionMapping {

	enum Action {
		LMB,
		RMB;

		public ActionInformation info() {
			return ControlActionMapping.getActionInformation();
		}
	}

	public class ActionInformation {

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

	public void fireAction(Action action) {
		for (ActionListener listener : listeners) {
			listener.action(action);
		}
	}
}
