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

	private List<ModelInstance> modelInstances = new ArrayList<ModelInstance>();

	public GridLines(Map map) {
		X_MAX = map.getSizeX();
		Y_MAX = map.getSizeY();
		buildGrid();
	}

	private void buildGrid() {
		ModelBuilder modelBuilder = new ModelBuilder();
		modelBuilder.begin();

		MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
		builder.setColor(Color.RED);

		buildVerticalLines(builder);
		buildHorizontalLines(builder);

		Model gridModel = modelBuilder.end();
		modelInstances.add(new ModelInstance(gridModel));
	}

	private void buildVerticalLines(MeshPartBuilder builder) {
		for (int x = 0; x <= X_MAX; x++) {
			builder.line(x, 0.0f, HEIGHT, x, Y_MAX, HEIGHT);
		}
	}

	private void buildHorizontalLines(MeshPartBuilder builder) {
		for (int y = 0; y <= Y_MAX; y++) {
			builder.line(0.0f, y, HEIGHT, X_MAX, y, HEIGHT);
		}
	}

	public List<ModelInstance> getModelInstances() {
		return modelInstances;
	}
}
