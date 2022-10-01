package main;

import java.io.File;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		File pluginFolder = new File("Plugins");
		pluginFolder.mkdir();// create plugins folder in current location.

		LinkedList<MyInterface> loadedClasses = (LinkedList<MyInterface>) PluginLoader.loadClasses(pluginFolder, MyInterface.class);
		for (MyInterface myInterface : loadedClasses) {
			System.out.println(myInterface.getMessage());
		}

		System.out.println("Done!");
	}
}
