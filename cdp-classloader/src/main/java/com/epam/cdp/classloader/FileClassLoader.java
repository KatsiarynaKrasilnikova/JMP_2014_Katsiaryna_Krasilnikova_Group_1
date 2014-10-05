package com.epam.cdp.classloader;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ilya_Kukushkin on 10/5/2014.
 */
public class FileClassLoader extends AbstractCustomClassLoader {

    @Override
    public Class<?> doFind(String path, String name) throws ClassNotFoundException {
        byte[] classData;

        try {
            classData = loadFileAsBytes(path, name);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class [" + name
                    + "] could not be found", e);
        }

        Class<?> clazz = defineClass(name, classData, 0, classData.length);
        resolveClass(clazz);

        return clazz;
    }

    private byte[] loadFileAsBytes(String path, String name)
            throws IOException {
        File file = findFile(path, name.replace('.', '/'), ".class");
        byte[] result = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            IOUtils.read(fileInputStream, result);
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
        return result;
    }
}
