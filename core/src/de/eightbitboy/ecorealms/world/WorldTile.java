package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class WorldTile {
	private Model model;
	private ModelInstance instance;

	public WorldTile() {
		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(1f, 1f, 1f,
				new Material(ColorAttribute.createDiffuse(Color.RED)),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		instance = new ModelInstance(model);
		instance.transform.translate(3, 0, 0);
	}

	public Model getModel() {
		return model;
	}

	public ModelInstance getModelInstance() {
		return instance;
	}
}
