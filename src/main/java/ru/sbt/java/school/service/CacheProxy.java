package ru.sbt.java.school.service;

import ru.sbt.java.school.model.ICache;

import java.lang.reflect.Proxy;

public class CacheProxy {
    public static ICalculator cache(Calculator calculator, ICache cache){
        return (ICalculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{ICalculator.class},
                new CacheProxyhandler(calculator, cache));
    }
}
