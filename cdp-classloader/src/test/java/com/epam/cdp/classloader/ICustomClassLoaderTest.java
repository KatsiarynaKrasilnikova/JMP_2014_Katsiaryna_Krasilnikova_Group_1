package com.epam.cdp.classloader;

import org.junit.Test;

import java.lang.reflect.Method;

public class ICustomClassLoaderTest {

    @Test
    public void testFindClass() throws Exception {
        ICustomClassLoader customClassLoader = new CacheClassLoader().setNext(new SystemClassLoader().setNext(new FileClassLoader()));

        Class<?> clazz = customClassLoader.findClass("C:/Users/Ilya_Kukushkin/Desktop/classloader", "com.epam.cdp.TestClass");
        Object o = clazz.newInstance();
        Method m = clazz.getMethod("f");
        m.invoke(o);
    }
}