package de.eightbitboy.ecorealms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.Arrays;
import java.util.List;

class Gizmo {

	private static final float SPACE = 5;

	private ModelInstance[] instances = new ModelInstance[4];

	Gizmo() {
		ModelInstance aCube = CubeFactory.getCube(Color.MAGENTA);
		ModelInstance xCube = CubeFactory.getCube(Color.RED);
		ModelInstance yCube = CubeFactory.getCube(Color.GREEN);
		ModelInstance zCube = CubeFactory.getCube(Color.BLUE);

		xCube.transform.translate(SPACE, 0, 0);
		yCube.transform.translate(0, SPACE, 0);
		zCube.transform.translate(0, 0, SPACE);

		instances[0] = aCube;
		instances[1] = xCube;
		instances[2] = yCube;
		instances[3] = zCube;
	}

	List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}
}
