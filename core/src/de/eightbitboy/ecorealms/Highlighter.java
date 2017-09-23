package de.eightbitboy.ecorealms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.logic.MapPoint;

class Highlighter {

	private ModelInstance[] instances = new ModelInstance[1];
	private Control control;
	private MapPoint mapPoint;
	private static final float HEIGHT = 0.01f;

	Highlighter(Control control) {
		this.control = control;

		ModelBuilder modelBuilder = new ModelBuilder();

		Material material = new Material(ColorAttribute.createDiffuse(Color.RED));

		Model model = modelBuilder.createRect(
				0, 0, HEIGHT,
				1, 0, HEIGHT,
				1, 1, HEIGHT,
				0, 1, HEIGHT,
				0, 0, 1, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		instances[0] = new ModelInstance(model);
	}

	void update() {
		mapPoint = control.getClickOnMap();
		instances[0].transform.setToTranslation(mapPoint.getX(), mapPoint.getY(), HEIGHT);
	}

	List<ModelInstance> getModelInstances() {
		if (mapPoint.isOnMap()) {
			return Arrays.asList(instances);
		} else {
			return new ArrayList<ModelInstance>();
		}
	}
}
