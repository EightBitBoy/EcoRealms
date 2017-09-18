package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Control extends InputAdapter implements InputProcessor {
	private int cameraX = 0;
	private int cameraY = 0;

	Control(PerspectiveCamera camera) {
	}

	@Override
	public boolean keyDown(int keycode) {
		Logger.debug("Key: " + keycode);

		switch (keycode) {
			case Keys.W:
				cameraY = +1;
				break;
			case Keys.A:
				cameraX = -1;
				break;
			case Keys.S:
				cameraY = -1;
				break;
			case Keys.D:
				cameraX = +1;
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Keys.W:
				cameraY = 0;
				break;
			case Keys.A:
				cameraX = 0;
				break;
			case Keys.S:
				cameraY = 0;
				break;
			case Keys.D:
				cameraX = 0;
				break;
		}
		return false;
	}
}
