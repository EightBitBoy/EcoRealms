package de.eightbitboy.ecorealms;

import com.badlogic.gdx.Gdx;

class Logger {
	static void debug(String message) {
		Gdx.app.debug("DEBUG", message);
	}

	static void info(String message) {
		Gdx.app.log("INFO", message);
	}

	static void error(String message) {
		Gdx.app.error("ERROR", message);
	}
}
