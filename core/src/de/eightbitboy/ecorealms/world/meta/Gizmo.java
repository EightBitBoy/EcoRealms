package de.eightbitboy.ecorealms.world.meta;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.world.ModelInstanceProvider;
import de.eightbitboy.ecorealms.world.factory.CuboidFactory;

public class Gizmo implements ModelInstanceProvider {

	private static final float SPACE = 5;

	private List<ModelInstance> instances = new ArrayList<ModelInstance>();

	public Gizmo() {
		ModelInstance aCube = CuboidFactory.getCube(Color.MAGENTA);
		ModelInstance xCube = CuboidFactory.getCube(Color.RED);
		ModelInstance yCube = CuboidFactory.getCube(Color.GREEN);
		ModelInstance zCube = CuboidFactory.getCube(Color.BLUE);

		xCube.transform.translate(SPACE, 0, 0);
		yCube.transform.translate(0, SPACE, 0);
		zCube.transform.translate(0, 0, SPACE);

		instances.add(aCube);
		instances.add(xCube);
		instances.add(yCube);
		instances.add(zCube);
	}

	public List<ModelInstance> getModelInstances() {
		return instances;
	}
}
