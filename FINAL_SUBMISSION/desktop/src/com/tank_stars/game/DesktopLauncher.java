package com.tank_stars.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.tank_stars.game.TankStarsGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void serialize() throws IOException {
		TankStarsGame game=new TankStarsGame();
		ObjectOutputStream out = null;
		try {
			out=new ObjectOutputStream(new FileOutputStream("out.txt"));
			out.writeObject(game);
		}
		finally {
			out.close();
		}
	}

	public static void deserialize() throws IOException, ClassNotFoundException{
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream(new FileInputStream("out.txt"));
			TankStarsGame game = (TankStarsGame) in.readObject();
		}
		finally {
			in.close();
		}
	}
	public static void main (String[] arg) throws IOException,ClassNotFoundException{
		serialize();
		deserialize();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Tank Stars Game");
		config.setWindowedMode(1280,720);
		config.useVsync(true);
		new Lwjgl3Application(new TankStarsGame(), config);

	}
}
