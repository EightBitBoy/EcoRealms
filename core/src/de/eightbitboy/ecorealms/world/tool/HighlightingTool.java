package de.eightbitboy.ecorealms.world.tool;

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

import de.eightbitboy.ecorealms.control.Action;
import de.eightbitboy.ecorealms.control.ActionListener;
import de.eightbitboy.ecorealms.control.ControlActionMapping;
import de.eightbitboy.ecorealms.world.ModelInstanceProvider;

public class Highlighter implements ActionListener, ModelInstanceProvider {

	private static final float CLICK_HEIGHT = 0.01f;
	private static final float HOVER_HEIGHT = CLICK_HEIGHT + 0.005f;

	private List<ModelInstance> instances = new ArrayList<ModelInstance>();

	private ModelInstance clickModel;
	private ModelInstance hoverModel;

	public Highlighter() {
		createModels();
		ControlActionMapping.subscribe(Action.LMB, this);
		ControlActionMapping.subscribe(Action.UPDATE, this);
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

		instances.add(clickModel);
		instances.add(hoverModel);
	}

	public List<ModelInstance> getModelInstances() {
		return instances;
	}

	@Override
	public void action(Action action) {
		if(action == Action.LMB) {
			clickModel.transform.setToTranslation(
					action.info().clickPositionOnMap.x,
					action.info().clickPositionOnMap.y,
					CLICK_HEIGHT);
		}
		if(action == Action.UPDATE) {
			hoverModel.transform.setToTranslation(
					action.info().hoverPositionOnMap.x,
					action.info().hoverPositionOnMap.y,
					HOVER_HEIGHT);
		}
	}
}
