package ru.sbt.java.school;

import ru.sbt.java.school.dao.AbsCacheDAO;
import ru.sbt.java.school.dao.CacheDAO;
import ru.sbt.java.school.model.Cache;
import ru.sbt.java.school.model.ICache;
import ru.sbt.java.school.service.CacheProxy;
import ru.sbt.java.school.service.Calculator;
import ru.sbt.java.school.service.ICalculator;

public class Main {
    public static void main(String[] args) {
        ICache cache =new Cache(new CacheDAO(AbsCacheDAO.URL));
        cache.load();
        ICalculator calculator = CacheProxy.cache(new Calculator(), cache);

        for (int i = 1; i < 47; i++) {
            System.out.println(i +" - " + calculator.fibonachi(i));
        }

    }
}
