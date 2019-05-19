package ru.sbt.java.school.service;

public interface ICalculator {
    @Cachable(persistent = true)
    int fibonachi(int n);
}
