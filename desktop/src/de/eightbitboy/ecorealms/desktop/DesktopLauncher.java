package de.eightbitboy.ecorealms.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.eightbitboy.ecorealms.EcoRealms;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1650;
		config.height = 1050;
		new LwjglApplication(new EcoRealms(), config);
	}
}
