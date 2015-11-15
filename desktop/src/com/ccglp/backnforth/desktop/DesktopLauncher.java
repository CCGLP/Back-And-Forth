package com.ccglp.backnforth.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ccglp.backnforth.Main_Handler;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = 64*10;
		//config.height = 64*10;
		config.fullscreen = true;
		new LwjglApplication(new Main_Handler(), config);
	}
}
