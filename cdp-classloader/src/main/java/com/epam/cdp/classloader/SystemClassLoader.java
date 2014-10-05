package com.epam.cdp.classloader;

import java.io.File;

/**
 * Created by Ilya_Kukushkin on 10/5/2014.
 */
public class SystemClassLoader extends AbstractCustomClassLoader {

    @Override
    public Class<?> doFind(String path, String name) throws ClassNotFoundException {
        File f = findFile(path, name.replace('.', '/'), ".class");
        if (f == null) {
            return findSystemClass(name);
        }
        return null;
    }
}
