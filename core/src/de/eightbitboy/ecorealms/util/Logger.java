package de.eightbitboy.ecorealms.util;

import com.badlogic.gdx.Gdx;

public class Logger {
	public static void debug(String message) {
		Gdx.app.debug("DEBUG", message);
	}

	static void info(String message) {
		Gdx.app.log("INFO", message);
	}

	static void error(String message) {
		Gdx.app.error("ERROR", message);
	}
}
