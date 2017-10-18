package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;

import de.eightbitboy.ecorealms.config.EcoRealmsConfig;
import de.eightbitboy.ecorealms.control.Control;
import de.eightbitboy.ecorealms.control.ControlActionMapping;
import de.eightbitboy.ecorealms.map.Map;
import de.eightbitboy.ecorealms.world.meta.GridLines;
import de.eightbitboy.ecorealms.world.World;
import de.eightbitboy.ecorealms.world.meta.Gizmo;
import de.eightbitboy.ecorealms.world.render.ModelBatchRenderer;
import de.eightbitboy.ecorealms.world.tool.Highlighter;

public class EcoRealms extends ApplicationAdapter {
	private EcoRealmsConfig config;
	private Map map;
	private World world;

	private Environment environment;
	private PerspectiveCamera camera;
	private ModelBatchRenderer modelBatchRenderer;

	private Control control;

	public EcoRealms() {
		this.config = new EcoRealmsConfig();
	}

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setupWorld();
		setupEnvironment();
		setupCamera();
		setupControl();
		setupRendering();
	}

	@Override
	public void render() {
		executeGlFunctions();

		control.updateCamera();
		ControlActionMapping.getInstance().update();
		camera.update();

		modelBatchRenderer.render();
	}

	private void executeGlFunctions() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	}

	private void setupWorld() {
		map = new Map(config.WORLD_SIZE_X, config.WORLD_SIZE_Y);
		world = new World(map);
	}

	private void setupEnvironment() {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, 1f, 0.5f, -0.8f));
	}

	private void setupCamera() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(-10f, -10f, 10f);
		camera.rotate(new Vector3(1, 0, 0), 90);
		camera.lookAt(0, 0, -5);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();
	}

	private void setupControl() {
		control = new Control(camera, ControlActionMapping.getInstance(), map);
		Gdx.input.setInputProcessor(control);
	}

	private void setupRendering() {
		modelBatchRenderer = new ModelBatchRenderer(environment, camera);
		modelBatchRenderer.add(world);
		modelBatchRenderer.add(new GridLines(map));
		modelBatchRenderer.add(new Highlighter());

		//noinspection ConstantConditions
		if(config.showGizmo) {
			modelBatchRenderer.add(new Gizmo());
		}
	}

	@Override
	public void dispose() {
		modelBatchRenderer.dispose();
	}
}
