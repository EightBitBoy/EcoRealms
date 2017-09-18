package de.eightbitboy.ecorealms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class CubeFactory {
	private static final float SIZE = 1;

	static ModelInstance getCube(Color color) {
		ModelBuilder modelBuilder = new ModelBuilder();
		Material material = new Material(ColorAttribute.createDiffuse(color));
		Model model = modelBuilder.createBox(SIZE, SIZE, SIZE, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		return new ModelInstance(model);
	}
}
