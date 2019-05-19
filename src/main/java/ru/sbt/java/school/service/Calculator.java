package ru.sbt.java.school.service;

public class Calculator implements ICalculator {
    @Override
    public int fibonachi(int n) {
        int a = 1;
        int b = 1;
        int res = 0;

        if (n < 1 || n > 46) throw new IllegalArgumentException("1 <= n <= 46");
        if (n == 1 || n == 2) return 1;

        for (int i = 2; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
