package com.designpattern.demo.Singleton;

import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) {
        ThreadSafeSingleton tss1 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        ThreadSafeSingleton tss2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        System.out.println("Are same classes ? "+(tss1 == tss2));

        ThreadSafeSingleton tss3 = null;

        try {
            Constructor[] constructors = ThreadSafeSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                tss3 = (ThreadSafeSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tss1.hashCode());
        System.out.println(tss3.hashCode());


    }
}
