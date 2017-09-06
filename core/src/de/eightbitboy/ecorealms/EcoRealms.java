package de.eightbitboy.ecorealms;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.eightbitboy.ecorealms.world.World;

public class EcoRealms extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;

	private EcoRealmsConfig config;
	private World world;
	private PerspectiveCamera cam;

	public EcoRealms() {
		this.config = new EcoRealmsConfig();
	}

	public EcoRealms(EcoRealmsConfig config) {
		this.config = config;
	}

	@Override
	public void create() {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		createWorld();
		createCamera();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	private void createWorld() {
		world = new World(config.WORLD_SIZE_X, config.WORLD_SIZE_Y);
	}

	private void createCamera() {
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
	}
}
