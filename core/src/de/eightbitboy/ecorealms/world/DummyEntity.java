package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.map.MapEntity;
import de.eightbitboy.ecorealms.map.Position;
import de.eightbitboy.ecorealms.world.factory.CuboidFactory;

public class DummyEntity implements MapEntity, ModelInstanceProvider {

	private Position position;
	private List<ModelInstance> instances = new ArrayList<ModelInstance>();

	public DummyEntity(Position position) {
		this.position = position;

		ModelInstance ground = CuboidFactory.getCuboid(1, 1, 5, Color.BROWN);
		ground.transform.setToTranslation(0, 0, 0);
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getSizeX() {
		return 1;
	}

	@Override
	public int getSizeY() {
		return 1;
	}

	@Override
	public String toString() {
		return getClass().getName() + position.toString();
	}

	@Override
	public List<ModelInstance> getModelInstances() {
		return instances;
	}
}
