package de.eightbitboy.ecorealms.world.render;


import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

import de.eightbitboy.ecorealms.world.ModelInstanceProvider;

public class ModelBatchRenderer implements Disposable {

	private Environment environment;
	private PerspectiveCamera camera;
	private ModelBatch modelBatch = new ModelBatch();
	private List<ModelInstanceProvider> providers = new ArrayList<ModelInstanceProvider>();

	public ModelBatchRenderer(Environment environment, PerspectiveCamera camera) {
		this.environment = environment;
		this.camera = camera;
	}

	public void add(ModelInstanceProvider provider) {
		providers.add(provider);
	}

	public void render() {
		modelBatch.begin(camera);
		renderModels();
		modelBatch.end();
	}

	private void renderModels() {
		//TODO Use stream API!
		for (ModelInstanceProvider provider : providers) {
			modelBatch.render(provider.getModelInstances(), environment);
		}
	}

	@Override
	public void dispose() {
		modelBatch.dispose();
	}
}
