package de.eightbitboy.ecorealms.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.map.Map;

public class GridLines {

	private final float HEIGHT = 0.01f;
	private final float X_MAX;
	private final float Y_MAX;

	private List<ModelInstance> modelInstances;

	public GridLines(Map map) {
		modelInstances = new ArrayList<ModelInstance>();
		X_MAX = map.getSizeX();
		Y_MAX = map.getSizeY();

		buildGrid();
	}

	private void buildGrid() {
		ModelBuilder modelBuilder = new ModelBuilder();
		modelBuilder.begin();

		MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
		builder.setColor(Color.RED);

		for (int x = 0; x <= X_MAX; x++) {
			builder.line(x, 0.0f, HEIGHT, x, Y_MAX, HEIGHT);
		}
		for (int y = 0; y <= Y_MAX; y++) {
			builder.line(0.0f, y, HEIGHT, X_MAX, y, HEIGHT);
		}

		Model gridModel = modelBuilder.end();
		modelInstances.add(new ModelInstance(gridModel));
	}

	public List<ModelInstance> getModelInstances() {
		return modelInstances;
	}
}
