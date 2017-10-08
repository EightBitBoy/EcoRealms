package de.eightbitboy.ecorealms.world.factory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class CuboidFactory {
	private static final float SIZE = 1;

	public static ModelInstance getCuboid(float x, float y, float z, Color color) {
		ModelBuilder modelBuilder = new ModelBuilder();
		Material material = new Material(ColorAttribute.createDiffuse(color));

		Model model = modelBuilder.createBox(x, y, z, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		return new ModelInstance(model);
	}

	public static ModelInstance getCube(Color color) {
		return getCuboid(SIZE, SIZE, SIZE, color);
	}
}
