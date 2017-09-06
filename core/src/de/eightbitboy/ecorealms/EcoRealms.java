package de.eightbitboy.ecorealms;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.eightbitboy.ecorealms.world.World;

public class EcoRealms extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;

	private EcoRealmsConfig config;
	private World world;


	public EcoRealms() {
		this.config = new EcoRealmsConfig();
	}

	public EcoRealms(EcoRealmsConfig config) {
		this.config = config;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		world = new World(config.WORLD_SIZE_X, config.WORLD_SIZE_Y);
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
}
