package com.epam.cdp.classloader;

import org.apache.log4j.Logger;

/**
 * Created by Ilya_Kukushkin on 10/5/2014
 */
public abstract class AbstractCustomClassLoader extends ClassLoader implements ICustomClassLoader {

    protected final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public final Class<?> findClass(String path, String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        try {
            clazz = loadClass(name);
        } catch (ClassNotFoundException e) {
        }

        if (clazz != null) {
            logger.info("Class " + name + " found in cache");
            return clazz;
        }

        clazz = doFind(path, name);
        return clazz;
    }

    protected abstract Class<?> doFind(String path, String name) throws ClassNotFoundException;
}