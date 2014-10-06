package com.epam.cdp.classloader;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Ilya_Kukushkin on 10/6/2014.
 */
public class JarClassLoader extends AbstractCustomClassLoader {
    @Override
    protected Class<?> doFind(String path, String name) throws ClassNotFoundException {
        try {
            JarFile zipFile = new JarFile(path);
            Enumeration<? extends JarEntry> e = zipFile.entries();

            while (e.hasMoreElements()) {
                JarEntry entry = (JarEntry) e.nextElement();

                if (!entry.isDirectory() && entry.getName().equals(name.replace('.', '/') + ".class")) {

                    byte[] result = new byte[(int) entry.getSize()];
                    try (BufferedInputStream bis = new BufferedInputStream(
                            zipFile.getInputStream(entry))) {
                        IOUtils.read(bis, result);
                    }

                    Class<?> clazz = defineClass(name, result, 0, result.length);
                    resolveClass(clazz);

                    return clazz;

                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
