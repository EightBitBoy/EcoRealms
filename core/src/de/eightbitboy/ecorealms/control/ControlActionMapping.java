package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.List;

public class ControlActionMapping {

	enum Action {
		LMB,
		RMB
	}

	public interface ActionListener {
		void action(Action action);
	}

	private static final ControlActionMapping INSTANCE = new ControlActionMapping();

	private List<ActionListener> listeners = new ArrayList<ActionListener>();

	private ControlActionMapping() {
	}

	public static ControlActionMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(ActionListener listener) {
		INSTANCE.listeners.add(listener);
	}

	public void fireAction(Action action) {
		for (ActionListener listener : listeners) {
			listener.action(action);
		}
	}
}
