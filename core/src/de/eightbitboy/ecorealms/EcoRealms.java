package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

import de.eightbitboy.ecorealms.config.EcoRealmsConfig;
import de.eightbitboy.ecorealms.control.Control;
import de.eightbitboy.ecorealms.control.ControlActionMapping;
import de.eightbitboy.ecorealms.entity.EntityEngine;
import de.eightbitboy.ecorealms.map.Map;
import de.eightbitboy.ecorealms.world.camera.FlyingCamera;
import de.eightbitboy.ecorealms.world.meta.GridLines;
import de.eightbitboy.ecorealms.world.World;
import de.eightbitboy.ecorealms.world.meta.Gizmo;
import de.eightbitboy.ecorealms.world.render.ModelBatchRenderer;
import de.eightbitboy.ecorealms.world.tool.BuildTool;
import de.eightbitboy.ecorealms.world.tool.HighlightingTool;

public class EcoRealms extends ApplicationAdapter {
	private EcoRealmsConfig config;

	private Map map;
	private World world;
	private Environment environment;
	private PerspectiveCamera camera;
	private Control control;
	private EntityEngine engine;
	private ModelBatchRenderer modelBatchRenderer;

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
		setupEntityEngine();
		setupRendering();

		new BuildTool(map);
	}

	@Override
	public void render() {
		executeGlFunctions();

		//TODO
		engine.update(Gdx.graphics.getDeltaTime());

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
		camera = new FlyingCamera();
	}

	private void setupControl() {
		control = new Control(camera, ControlActionMapping.getInstance(), map);
		Gdx.input.setInputProcessor(control);
	}

	private void setupEntityEngine() {
		engine = new EntityEngine();
	}

	private void setupRendering() {
		modelBatchRenderer = new ModelBatchRenderer(environment, camera);
		modelBatchRenderer.add(world);
		modelBatchRenderer.add(new GridLines(map));
		modelBatchRenderer.add(new HighlightingTool());

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
