package de.eightbitboy.ecorealms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.control.Control;

class Highlighter {

	private static final float CLICK_HEIGHT = 0.01f;
	private static final float HOVER_HEIGHT = CLICK_HEIGHT + 0.005f;
	private Control control;

	private ModelInstance[] instances = new ModelInstance[2];

	private ModelInstance clickModel;
	private ModelInstance hoverModel;

	Highlighter(Control control) {
		this.control = control;
		createModels();
	}

	private void createModels() {
		ModelBuilder modelBuilder = new ModelBuilder();

		Material material = new Material(ColorAttribute.createDiffuse(Color.RED));
		Model model = modelBuilder.createRect(
				0, 0, CLICK_HEIGHT,
				1, 0, CLICK_HEIGHT,
				1, 1, CLICK_HEIGHT,
				0, 1, CLICK_HEIGHT,
				0, 0, 1, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		clickModel = new ModelInstance(model);

		material = new Material(ColorAttribute.createDiffuse(Color.LIME));
		model = modelBuilder.createRect(
				0, 0, HOVER_HEIGHT,
				1, 0, HOVER_HEIGHT,
				1, 1, HOVER_HEIGHT,
				0, 1, HOVER_HEIGHT,
				0, 0, 1, material,
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		hoverModel = new ModelInstance(model);

		instances[0] = clickModel;
		instances[1] = hoverModel;
	}

	void update() {
		clickModel.transform.setToTranslation(
				control.getClickOnMap().x,
				control.getClickOnMap().y, CLICK_HEIGHT);
		hoverModel.transform.setToTranslation(
				control.getHoverOverMap().x,
				control.getHoverOverMap().y, HOVER_HEIGHT);
	}

	List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}
}
