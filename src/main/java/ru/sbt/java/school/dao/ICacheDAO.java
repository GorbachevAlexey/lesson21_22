package ru.sbt.java.school.dao;

import java.util.Map;

public interface ICacheDAO {
    void save(Integer key, Integer value);
    Map<Integer,Integer> load();
}
