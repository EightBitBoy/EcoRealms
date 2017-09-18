package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Control extends InputAdapter implements InputProcessor {
	private static final float SENSITIVITY = 0.2f;
	private PerspectiveCamera camera;
	private int cameraX = 0;
	private int cameraY = 0;

	Control(PerspectiveCamera camera) {
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		Logger.debug("Key: " + Keys.toString(keycode));

		switch (keycode) {
			case Keys.W:
				cameraX = +1;
				cameraY = +1;
				break;
			case Keys.A:
				cameraX = -1;
				cameraY = +1;
				break;
			case Keys.S:
				cameraX = -1;
				cameraY = -1;
				break;
			case Keys.D:
				cameraX = +1;
				cameraY = -1;
				break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Keys.W:
				cameraX = 0;
				cameraY = 0;
				break;
			case Keys.A:
				cameraX = 0;
				cameraY = 0;
				break;
			case Keys.S:
				cameraX = 0;
				cameraY = 0;
				break;
			case Keys.D:
				cameraX = 0;
				cameraY = 0;
				break;
		}
		return false;
	}

	void update() {
		camera.position.x += cameraX * SENSITIVITY;
		camera.position.y += cameraY * SENSITIVITY;
	}
}
