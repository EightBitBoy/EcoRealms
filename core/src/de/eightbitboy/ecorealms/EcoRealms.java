package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;

import de.eightbitboy.ecorealms.logic.Map;
import de.eightbitboy.ecorealms.world.World;

public class EcoRealms extends ApplicationAdapter {
	private EcoRealmsConfig config;
	private World world;

	private Environment environment;
	private PerspectiveCamera camera;
	private ModelBatch modelBatch;

	private Control control;
	private Gizmo gizmo;

	public EcoRealms() {
		this.config = new EcoRealmsConfig();
	}

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		createWorld();
		createEnvironment();
		createCamera();

		modelBatch = new ModelBatch();
		gizmo = new Gizmo();

		control = new Control(camera);
		Gdx.input.setInputProcessor(control);
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		//unproject, pickray
		control.updateCamera();
		camera.update();

		modelBatch.begin(camera);
		renderModels();
		modelBatch.end();
	}

	@Override
	public void dispose() {
		modelBatch.dispose();
	}

	@SuppressWarnings("ConstantConditions")
	private void renderModels() {
		modelBatch.render(world.getModelInstances(), environment);
		if (config.showGizmo) modelBatch.render(gizmo.getModelInstances(), environment);
	}

	private void createWorld() {
		Map map = new Map(config.WORLD_SIZE_X, config.WORLD_SIZE_Y);
		world = new World(map);
	}

	private void createEnvironment() {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, 1f, 0.5f, -0.8f));
	}

	private void createCamera() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(-10f, -10f, 10f);
		camera.rotate(new Vector3(1, 0, 0), 90);
		camera.lookAt(0, 0, 0);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();
	}
}
