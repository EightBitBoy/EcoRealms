package de.eightbitboy.ecorealms.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.apache.log4j.BasicConfigurator;

import de.eightbitboy.ecorealms.EcoRealms;

public class DesktopLauncher {
	public static void main(String[] arg) {
		//TODO Is this the correct place for this?
		BasicConfigurator.configure();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new EcoRealms(), config);
	}
}
