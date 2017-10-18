package de.eightbitboy.ecorealms.world.tool;

import de.eightbitboy.ecorealms.control.Action;
import de.eightbitboy.ecorealms.control.ActionListener;
import de.eightbitboy.ecorealms.control.ControlActionMapping;
import de.eightbitboy.ecorealms.map.Map;
import de.eightbitboy.ecorealms.util.Logger;
import de.eightbitboy.ecorealms.world.DummyEntity;

public class BuildTool implements ActionListener {
	private Map map;

	public BuildTool(Map map) {
		this.map = map;
		ControlActionMapping.subscribe(Action.LMB, this);
	}

	@Override
	public void action(Action action) {
		DummyEntity dummy = new DummyEntity(action.info().clickPositionOnMap);
		Logger.debug(dummy.toString());
		if (action == Action.LMB) {
			map.put(dummy);
		}
	}
}
