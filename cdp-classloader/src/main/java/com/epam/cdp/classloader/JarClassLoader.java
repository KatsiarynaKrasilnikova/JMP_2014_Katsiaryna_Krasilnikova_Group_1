package com.epam.cdp.classloader;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Ilya_Kukushkin on 10/6/2014
 */
public class JarClassLoader extends AbstractCustomClassLoader {

    @Override
    protected Class<?> doFind(String path, String name) throws ClassNotFoundException {

        byte[] classData = null;

        try {
            classData = loadFileAsBytes(path, name);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class [" + name
                    + "] could not be found", e);
        }

        Class<?> clazz = null;
        if (classData != null) {
            clazz = defineClass(name, classData, 0, classData.length);
            resolveClass(clazz);
            logger.info("Class " + name + " found in " + path);
        }

        return clazz;
    }

    private byte[] loadFileAsBytes(String path, String name)
            throws IOException {
        JarFile jarFile = new JarFile(path);
        Enumeration<? extends JarEntry> e = jarFile.entries();

        while (e.hasMoreElements()) {
            JarEntry entry = (JarEntry) e.nextElement();

            if (!entry.isDirectory() && entry.getName().equals(name.replace('.', '/') + ".class")) {
                byte[] result = new byte[(int) entry.getSize()];
                BufferedInputStream bis = null;
                try {
                    bis = new BufferedInputStream(
                            jarFile.getInputStream(entry));
                    IOUtils.read(bis, result);
                } finally {
                    if (bis != null) {
                        bis.close();
                    }
                }
                return result;
            } else {
                continue;
            }
        }
        return null;
    }
}
