package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.world.factory.CuboidFactory;
import de.eightbitboy.ecorealms.map.Map;

public class World {

	private List<ModelInstance> instances = new ArrayList<ModelInstance>();

	public World(Map map) {
		ModelInstance ground = CuboidFactory.getCuboid(map.getSizeX(), map.getSizeY(), 3, new Color(0x208400ff));
		ground.transform.setToTranslation(map.getSizeX() / 2, map.getSizeY() / 2, -1.5f);

		ModelInstance shore = CuboidFactory.getCuboid(map.getSizeX() + 2, map.getSizeY() + 2, 3, Color.YELLOW);
		shore.transform.setToTranslation(((map.getSizeX() + 2) / 2) - 1, ((map.getSizeY() + 2) / 2) - 1, -1.9f);

		ModelInstance sea = CuboidFactory.getCuboid(map.getSizeX() + 100, map.getSizeY() + 100, 3, Color.BLUE);
		sea.transform.setToTranslation(((map.getSizeX() + 100) / 2) - 50, ((map.getSizeY() + 100) / 2) - 50, -2.5f);

		instances.add(ground);
		instances.add(shore);
		instances.add(sea);
	}

	public List<ModelInstance> getModelInstances() {
		return instances;
	}
}
