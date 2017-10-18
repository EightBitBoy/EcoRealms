package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.map.MapChangeListener;
import de.eightbitboy.ecorealms.map.MapEntity;
import de.eightbitboy.ecorealms.util.Logger;
import de.eightbitboy.ecorealms.world.factory.CuboidFactory;
import de.eightbitboy.ecorealms.map.Map;

public class World implements ModelInstanceProvider, MapChangeListener {

	private List<ModelInstance> islandInstances = new ArrayList<ModelInstance>();
	private List<ModelInstance> entityInstances = new ArrayList<ModelInstance>();

	private Map map;

	public World(Map map) {
		this.map = map;
		this.map.subscribe(this);
		createIsland();
	}

	private void createIsland() {
		ModelInstance ground = CuboidFactory.getCuboid(map.getSizeX(), map.getSizeY(), 3, new Color(0x208400ff));
		ground.transform.setToTranslation(map.getSizeX() / 2, map.getSizeY() / 2, -1.5f);

		ModelInstance shore = CuboidFactory.getCuboid(map.getSizeX() + 2, map.getSizeY() + 2, 3, Color.YELLOW);
		shore.transform.setToTranslation(((map.getSizeX() + 2) / 2) - 1, ((map.getSizeY() + 2) / 2) - 1, -1.9f);

		ModelInstance sea = CuboidFactory.getCuboid(map.getSizeX() + 100, map.getSizeY() + 100, 3, Color.BLUE);
		sea.transform.setToTranslation(((map.getSizeX() + 100) / 2) - 50, ((map.getSizeY() + 100) / 2) - 50, -2.5f);

		islandInstances.add(ground);
		islandInstances.add(shore);
		islandInstances.add(sea);
	}

	public List<ModelInstance> getModelInstances() {
		//TODO Make this more performant!
		List<ModelInstance> instances = new ArrayList<ModelInstance>();
		instances.addAll(islandInstances);
		instances.addAll(entityInstances);
		return instances;
	}

	@Override
	public void mapChanged() {
		entityInstances.clear();
		for (MapEntity entity : map.getAllEntities()) {
			entityInstances.addAll(((ModelInstanceProvider) entity).getModelInstances());
		}
		Logger.debug(entityInstances.toString());
	}
}
