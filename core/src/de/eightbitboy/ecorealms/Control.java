package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

import de.eightbitboy.ecorealms.logic.Map;
import de.eightbitboy.ecorealms.logic.MapPoint;

public class Control extends InputAdapter implements InputProcessor {
	private static final float SENSITIVITY = 0.2f;

	private PerspectiveCamera camera;
	private Map map;
	private int cameraX = 0;
	private int cameraY = 0;

	private boolean lmbDown = false;
	private boolean rmbDown = false;
	private int mouseClickX = 0;
	private int mouseClickY = 0;
	private int mouseHoverX = 0;
	private int mouseHoverY = 0;

	private Plane mapPlane = new Plane(new Vector3(0, 0, 1), 0);
	private Ray clickRay;
	private Ray hoverRay;
	private Vector3 intersection = new Vector3();

	Control(PerspectiveCamera camera, Map map) {
		this.camera = camera;
		this.map = map;

		this.clickRay = camera.getPickRay(0, 0);
		this.hoverRay = camera.getPickRay(0, 0);
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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		mouseClickX = screenX;
		mouseClickY = screenY;

		clickRay = camera.getPickRay(mouseClickX, mouseClickY);

		switch (button) {
			case Buttons.LEFT:
				lmbDown = true;
				Logger.debug("Key: LMB");
				break;
			case Buttons.RIGHT:
				rmbDown = true;
				Logger.debug("Key: RMB");
				break;
		}

		//Logger.debug("Screen: " + screenX + "," + screenY);
		return super.touchDown(screenX, screenY, pointer, button);
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		switch (button) {
			case Buttons.LEFT:
				lmbDown = false;
				break;
			case Buttons.RIGHT:
				rmbDown = false;
				break;
		}
		return super.touchUp(screenX, screenY, pointer, button);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mouseHoverX = screenX;
		mouseHoverY = screenY;

		clickRay = camera.getPickRay(mouseHoverX, mouseHoverY);

		return super.mouseMoved(screenX, screenY);
	}

	void updateCamera() {
		camera.position.x += cameraX * SENSITIVITY;
		camera.position.y += cameraY * SENSITIVITY;
	}

	MapPoint getClickOnMap() {
		Intersector.intersectRayPlane(clickRay, mapPlane, intersection);
		return new MapPoint((int) intersection.x, (int) intersection.y);
	}

	public MapPoint getHoverOverMap() {
		Intersector.intersectRayPlane(hoverRay, mapPlane, intersection);
		return new MapPoint((int) intersection.x, (int) intersection.y);
	}
}
