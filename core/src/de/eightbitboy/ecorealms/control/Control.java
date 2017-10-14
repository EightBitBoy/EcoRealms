package de.eightbitboy.ecorealms.control;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

import de.eightbitboy.ecorealms.util.Logger;
import de.eightbitboy.ecorealms.map.Map;
import de.eightbitboy.ecorealms.map.Position;

public class Control extends InputAdapter implements InputProcessor {
	private static final float SENSITIVITY = 0.2f;

	private PerspectiveCamera camera;
	private ControlActionMapping controlActionMapping;
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
	private Vector3 clickIntersection = new Vector3();
	private Vector3 hoverIntersection = new Vector3();

	public Control(PerspectiveCamera camera, ControlActionMapping controlActionMapping, Map map) {
		this.camera = camera;
		this.controlActionMapping = controlActionMapping;
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

		clickRay = camera.getPickRay(mouseClickX, mouseClickY).cpy();

		switch (button) {
			case Buttons.LEFT:
				lmbDown = true;
				controlActionMapping.setClickPositionOnMap(getClickOnMap());
				controlActionMapping.fire(Action.LMB);
				Logger.debug("Key: LMB");
				break;
			case Buttons.RIGHT:
				rmbDown = true;
				controlActionMapping.setClickPositionOnMap(getClickOnMap());
				controlActionMapping.fire(Action.RMB);
				Logger.debug("Key: RMB");
				break;
		}

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

		controlActionMapping.setHoverPositionOnMap(getHoverOverMap());

		return super.mouseMoved(screenX, screenY);
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		//TODO
		if (lmbDown) {

		}
		return super.touchDragged(screenX, screenY, pointer);
	}

	public void updateCamera() {
		camera.position.x += cameraX * SENSITIVITY;
		camera.position.y += cameraY * SENSITIVITY;
	}

	private Position getClickOnMap() {
		Intersector.intersectRayPlane(clickRay, mapPlane, clickIntersection);
		return new Position((int) clickIntersection.x, (int) clickIntersection.y);
	}

	private Position getHoverOverMap() {
		hoverRay = camera.getPickRay(mouseHoverX, mouseHoverY);
		Intersector.intersectRayPlane(hoverRay, mapPlane, hoverIntersection);
		return new Position((int) hoverIntersection.x, (int) hoverIntersection.y);
	}
}
