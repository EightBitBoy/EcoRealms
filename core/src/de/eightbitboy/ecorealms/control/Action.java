package de.eightbitboy.ecorealms.control;

public enum Action {
	LMB,
	RMB,
	UPDATE;

	public ControlActionMapping.ActionInformation info() {
		return ControlActionMapping.getActionInformation();
	}
}
