package de.eightbitboy.ecorealms.control;

import java.util.ArrayList;
import java.util.List;

public class ControlMapping {

	enum Action {
		LMB,
		RMB
	}

	public interface ActionListener {
		void action(Action action);
	}

	private static final ControlMapping INSTANCE = new ControlMapping();

	private List<ActionListener> listeners = new ArrayList<ActionListener>();

	private ControlMapping() {
	}

	public static ControlMapping getInstance() {
		return INSTANCE;
	}

	public static void subscribe(ActionListener listener) {
		INSTANCE.listeners.add(listener);
	}

	public void fireAction(Action action) {
		
	}
}
