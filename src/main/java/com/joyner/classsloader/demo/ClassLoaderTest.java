package com.joyner.classsloader.demo;

import sun.misc.Launcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //创建自定义classloader对象。
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib\\");
        try {
            //加载class文件
            //注意，这里调用loadClass，当系统类加载器找不到类的时候，会去调用我们定义的findClass方法。
            Class c = diskLoader.loadClass("com.joyner.classsloader.demo.Test");

            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say",null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
