package com.epam.labs.lab1;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {
    public long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("You cannot take factorial of a negative number.");
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    public double divide(double lhs, double rhs) {
        if (rhs == 0) {
            throw new IllegalArgumentException("You cannot divide by zero.");
        }
        return lhs / rhs;
    }

    public double multiply(double lhs, double rhs) {
        return lhs * rhs;
    }
}
