package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Gdx;

class Logger {
	static void debug(String message) {
		Gdx.app.debug("debug", message);
	}
}
