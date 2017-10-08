package de.eightbitboy.ecorealms.world.meta;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.world.factory.CuboidFactory;

public class Gizmo {

	private static final float SPACE = 5;

	private ModelInstance[] instances = new ModelInstance[4];

	public Gizmo() {
		ModelInstance aCube = CuboidFactory.getCube(Color.MAGENTA);
		ModelInstance xCube = CuboidFactory.getCube(Color.RED);
		ModelInstance yCube = CuboidFactory.getCube(Color.GREEN);
		ModelInstance zCube = CuboidFactory.getCube(Color.BLUE);

		xCube.transform.translate(SPACE, 0, 0);
		yCube.transform.translate(0, SPACE, 0);
		zCube.transform.translate(0, 0, SPACE);

		instances[0] = aCube;
		instances[1] = xCube;
		instances[2] = yCube;
		instances[3] = zCube;
	}

	public List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}
}
