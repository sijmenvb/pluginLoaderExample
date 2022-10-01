package main;

import java.io.File;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		File pluginFolder = new File("Plugins");
		pluginFolder.mkdir();// create plugins folder in current location.
		
		//load the plugins that implement MyInterface
		LinkedList<MyInterface> loadedClasses = PluginLoader.loadClasses(pluginFolder, MyInterface.class);
		
		//print all the messages of all the loaded plugins.
		for (MyInterface myInterface : loadedClasses) {
			System.out.println(myInterface.getMessage());
		}

		System.out.println("Done!");
	}
}
