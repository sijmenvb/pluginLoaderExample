package main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;

/**
 * will load plugins from the plugins folder
 * 
 * @author sijmen_v_b
 */
public class PluginLoader {
	public LinkedList<MyInterface> loadMyInterfaceClasses(File pluginFolder) {
		File[] listOfFiles = pluginFolder.listFiles();
		LinkedList<MyInterface> list = new LinkedList<MyInterface>();
		for (File file : listOfFiles) {// go over all files
			if (file.isFile()) {// if it is a file load it
				try {
					URLClassLoader classLoader = new URLClassLoader(new URL[] { file.toURI().toURL() });//get the class loader for the current file
					Class<?> c = classLoader.loadClass("plugins." + file.getName().replaceAll(".jar", ""));//look for the class in package plugins with the same name as the file.
					MyInterface el = (MyInterface) c.getConstructor().newInstance();
					list.add(el);
					System.out.println(String.format("Successfully loaded \"%s\" plugin!", file.getName()));
				} catch (Exception e) {
					//Fail silently
					//e.printStackTrace();
				}
			}
		}
		return list;
	}
}
