package ru.sbt.java.school.model;

import ru.sbt.java.school.dao.ICacheDAO;

import java.util.HashMap;
import java.util.Map;

public class Cache implements ICache {
    private Map<Integer, Integer> cacheMap = new HashMap<>();
    private ICacheDAO cacheDAO;

    public Cache(ICacheDAO cacheDAO) {
        this.cacheDAO = cacheDAO;
    }

    @Override
    public void put(Integer key, Integer value, boolean persistent) {
        cacheMap.put(key, value);
        if (persistent) cacheDAO.save(key, value);
    }

    @Override
    public Integer get(Integer key) {
        return cacheMap.get(key);
    }

    @Override
    public void load() {
        cacheMap = cacheDAO.load();
    }
}
