package de.eightbitboy.ecorealms.world.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

public class FlyingCamera extends PerspectiveCamera {
	public FlyingCamera() {
		super(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		position.set(-10f, -10f, 10f);
		rotate(new Vector3(1, 0, 0), 90);
		lookAt(0, 0, -5);
		near = 1f;
		far = 300f;
		update();
	}
}
