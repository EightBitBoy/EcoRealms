package de.eightbitboy.ecorealms.control;

public enum Action {
	LMB,
	RMB,
	UPDATE;

	public ActionInformation info() {
		return ControlActionMapping.getActionInformation();
	}
}
