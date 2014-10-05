package com.epam.cdp.classloader;

import java.io.File;

/**
 * Created by Ilya_Kukushkin on 10/5/2014.
 */
public abstract class AbstractCustomClassLoader extends ClassLoader implements ICustomClassLoader {

    private ICustomClassLoader next;

    @Override
    public final ICustomClassLoader setNext(ICustomClassLoader handler) {
        this.next = handler;
        return this;
    }

    @Override
    public final Class<?> findClass(String path, String name) throws ClassNotFoundException {
        Class<?> clazz = doFind(path, name);
        if (clazz == null && next != null) {
            return next.findClass(path, name);
        }
        return clazz;
    }

    protected abstract Class<?> doFind(String path, String name) throws ClassNotFoundException;

    protected File findFile(String path, String name, String extension) {
        File f = new File((new File(path).getPath()
                + File.separatorChar + name.replace('/', File.separatorChar) + extension));
        if (f.exists()) {
            return f;
        }
        return null;
    }
}