# pluginLoaderExample
A small example of loading plugins.

# The setup 
We have an interface or abstract class, in our case, MyInterface, which defines a getMessage()`  function.

Then we have two plugins that implement or extend this interface or abstract class. 
We make an instance of both of these and print the result of `getMessage()`

We want these two plugins to be loaded on runtime from a folder so they can be delivered separately or duplicated. 
We create a plugin folder where it will load the plugins.

# How does it load plugins? 
It loads plugins by using the `PluginLoader.loadClasses()`  function.

You give a folder to the function to look for the plugins (.jar files). You can also give the function an interface or abstract class.

The function looks through the jar files and ties to cast an instance of every class to the interface or abstract class you provided. 
Where this succeeds, it stores the instance in a list which is returned.

# how to write plugins.
We have a package named plugins where the code of the plugins resides. This package should not be built. although it could be beneficial to development (see NOTE!)

The plugins can be converted to a jar file and placed in the plugins folder to be loaded. (In Eclipse, simply right-click the file and select Export... -> Java-> JAR file.)

# NOTE!
The classloader will first try to load a class internally and only then check if the class with that name is in the jar file. 
If you include the plugin package in the build, you can code the plugin without having to export it to a jar after each revision.

Do make sure when building the application for deployment that the plugins package is excluded. 
Otherwise, updating (only) the plugin will not have any effect since it will always use the internal version.
