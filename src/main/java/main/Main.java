package main;

import java.io.File;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		File pluginFolder = new File("Plugins");
		pluginFolder.mkdir();// create plugins folder in current location.

		PluginLoader loader = new PluginLoader();
		LinkedList<MyInterface> loadedClasses = loader.loadMyInterfaceClasses(pluginFolder);
		for (MyInterface myInterface : loadedClasses) {
			System.out.println(myInterface.getMessage());
		}

		System.out.println("Done!");
	}
}
