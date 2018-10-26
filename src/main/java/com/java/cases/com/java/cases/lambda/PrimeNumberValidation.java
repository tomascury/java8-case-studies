package com.java.cases.com.java.cases.lambda;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeNumberValidation {

    private static boolean isPrime(int number) {

        /**
         * Java 7
         *
         * for (int i = 2; i < number; i++) {
         *      if (number % i == 0) return false;
         * }
         * return number > 1;
         */


        /**
         * Java 8
         */
        Predicate<Integer> isDivisible =  divisor -> number % divisor == 0;

        return number > 1 && IntStream.range(2, number).noneMatch(index -> isDivisible.test(index));
    }

    public static void main(String[] args) {

        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }

}
