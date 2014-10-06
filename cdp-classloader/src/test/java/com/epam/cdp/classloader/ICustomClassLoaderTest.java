package com.epam.cdp.classloader;

import org.junit.Test;

import java.lang.reflect.Method;

public class ICustomClassLoaderTest {

    @Test
    public void testFindClass() throws Exception {
        //ICustomClassLoader customClassLoader = new CacheClassLoader().setNext(new SystemClassLoader().setNext(new FileClassLoader()));
        ICustomClassLoader customClassLoader = new CacheClassLoader().setNext(new JarClassLoader());

        Class<?> clazz = customClassLoader.findClass("C:/Users/Ilya_Kukushkin/Desktop/classloader/test.jar", "com.epam.cdp.TestClass");
        Object o = clazz.newInstance();
        Method m = clazz.getMethod("toString");
        String s = (String) m.invoke(o);
        System.out.println(s);
    }
}