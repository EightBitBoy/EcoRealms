package de.eightbitboy.ecorealms.world.meta;

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
import de.eightbitboy.ecorealms.control.ControlActionMapping;

public class Highlighter implements ControlActionMapping.ActionListener {

	private static final float CLICK_HEIGHT = 0.01f;
	private static final float HOVER_HEIGHT = CLICK_HEIGHT + 0.005f;
	private Control control;

	private ModelInstance[] instances = new ModelInstance[2];

	private ModelInstance clickModel;
	private ModelInstance hoverModel;

	public Highlighter(Control control) {
		this.control = control;
		createModels();
		ControlActionMapping.subscribe(ControlActionMapping.Action.LMB, this);
		ControlActionMapping.subscribe(ControlActionMapping.Action.UPDATE, this);
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

	public List<ModelInstance> getModelInstances() {
		return Arrays.asList(instances);
	}

	@Override
	public void action(ControlActionMapping.Action action) {
		if (action == ControlActionMapping.Action.LMB) {
			clickModel.transform.setToTranslation(
					action.info().clickPositionOnMap.x,
					action.info().clickPositionOnMap.y,
					CLICK_HEIGHT);
		}
		if (action == ControlActionMapping.Action.UPDATE) {
			hoverModel.transform.setToTranslation(
					action.info().hoverPositionOnMap.x,
					action.info().hoverPositionOnMap.y,
					HOVER_HEIGHT);
		}
	}
}
