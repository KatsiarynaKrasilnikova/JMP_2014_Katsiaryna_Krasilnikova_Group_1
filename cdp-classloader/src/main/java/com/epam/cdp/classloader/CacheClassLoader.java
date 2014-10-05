package com.epam.cdp.classloader;

/**
 * Created by Ilya_Kukushkin on 10/5/2014.
 */
public class CacheClassLoader extends AbstractCustomClassLoader {

    @Override
    public Class<?> doFind(String path, String name) throws ClassNotFoundException {
        return findLoadedClass(name);
    }
}
