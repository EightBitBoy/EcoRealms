package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.logic.Map;

public class World {

	private ModelInstance[] instances = new ModelInstance[1];

	public World(Map map) {
		ModelBuilder modelBuilder = new ModelBuilder();

		Material material = new Material(ColorAttribute.createDiffuse(Color.YELLOW));

		Model model = modelBuilder.createRect(
				0, 0, 0,
				map.getSizeX(), 0, 0,
				map.getSizeX(), map.getSizeY(), 0,
				0, map.getSizeY(), 0,
				0, 0, 1, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		instances[0] = new ModelInstance(model);
	}

	public List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}
}
