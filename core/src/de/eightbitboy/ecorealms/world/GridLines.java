package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.ArrayList;
import java.util.List;

public class GridLines {

	private List<ModelInstance> modelInstances;

	public GridLines() {
		modelInstances = new ArrayList<ModelInstance>();
		ModelBuilder modelBuilder = new ModelBuilder();
		modelBuilder.begin();
		MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
		builder.setColor(Color.RED);
		builder.line(0.0f, 0.0f, -5.0f, 0.0f, 0.0f, 5.0f);
		Model lineModel = modelBuilder.end();
		modelInstances.add(new ModelInstance(lineModel));
	}

	public List<ModelInstance> getModelInstances() {
		return modelInstances;
	}
}
