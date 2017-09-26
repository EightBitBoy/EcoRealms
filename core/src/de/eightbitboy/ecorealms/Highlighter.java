package de.eightbitboy.ecorealms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Arrays;
import java.util.List;

import de.eightbitboy.ecorealms.logic.MapPoint;

class Highlighter {

	private static final float CLICK_HEIGHT = 0.01f;
	private static final float HOVER_HEIGHT = CLICK_HEIGHT + 0.005f;
	private Control control;

	private ModelInstance[] instances = new ModelInstance[2];

	private BlendingAttribute visible;
	private BlendingAttribute hidden;

	private ModelInstance clickModel;
	private ModelInstance hoverModel;
	@SuppressWarnings("FieldCanBeLocal")
	private MapPoint clickPoint;
	@SuppressWarnings("FieldCanBeLocal")
	private MapPoint hoverPoint;

	Highlighter(Control control) {
		this.control = control;
		createModels();

		this.visible = new BlendingAttribute(GL20.GL_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		this.visible.opacity = 1.0f;

		this.hidden = new BlendingAttribute(GL20.GL_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		this.hidden.opacity = 0.0f;
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
		clickPoint = control.getClickOnMap();
		hoverPoint = control.getHoverOverMap();

		BlendingAttribute blending = new BlendingAttribute(GL20.GL_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		blending.opacity = 0.5f;
		hoverModel.materials.get(0).set(blending);

		if (clickPoint.isOnMap()) {
			clickModel.materials.get(0).set(visible);
		} else {
			clickModel.materials.get(0).set(hidden);
		}

		if (hoverPoint.isOnMap()) {
			hoverModel.materials.get(0).set(visible);
		} else {
			hoverModel.materials.get(0).set(hidden);
		}

		clickModel.transform.setToTranslation(clickPoint.getX(), clickPoint.getY(), CLICK_HEIGHT);
		hoverModel.transform.setToTranslation(hoverPoint.getX(), hoverPoint.getY(), HOVER_HEIGHT);
	}

	List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}
}
