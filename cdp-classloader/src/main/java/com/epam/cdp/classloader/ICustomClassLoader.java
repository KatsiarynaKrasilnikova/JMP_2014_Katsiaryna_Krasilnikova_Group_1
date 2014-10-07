package com.epam.cdp.classloader;

/**
 * Created by Ilya_Kukushkin on 10/5/2014
 */
public interface ICustomClassLoader {
    public Class<?> findClass(String path, String name) throws ClassNotFoundException;
}
