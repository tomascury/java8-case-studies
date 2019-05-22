package com.java.cases.com.java.cases.lambda;

import java.util.*;
import java.util.stream.*;

public class FrequencyCalculator {

    private static final int NUMBERS_LIST_SIZE = 100000;

    public static void main(String[] args) {

        List<Integer> numbers = createNumbersList();

        long startingTime = System.currentTimeMillis();

        System.out.println("Java 7 result: " + getRepeated(numbers));

        long totalTime = System.currentTimeMillis() - startingTime;

        System.out.println("Time: " + totalTime / 1000 + "s");

        startingTime = System.currentTimeMillis();

        System.out.println("Java 8 result: " + _getRepeated(numbers));

        totalTime = System.currentTimeMillis() - startingTime;

        System.out.println("Parallel Time: " + totalTime / 1000 + "s");

    }

    /**
     * Java 7
     *
     * @param numbers
     * @return @{@link Collection<Integer>}
     */
    private static Collection<Integer> getRepeated(List<Integer> numbers) {

        List<Integer> repeated = new ArrayList<>();

        for (Integer value : numbers) {

            if (getFrequency(numbers, value) > 1) {
                repeated.add(value);
            }
        }
        return new HashSet<>(repeated);
    }

    /**
     * Java 7
     *
     * @param input
     * @param base
     * @return @int
     */
    private static int getFrequency(List<Integer> input, Integer base) {

        int result = 0;

        for (Integer item : input) {
            if (base != null && base.intValue() == item.intValue()) {
                result++;
            }
        }
        return result;
    }

    /**
     * Java 8 Stream
     *
     * @param numbers
     * @return @{@link Collection<Integer>}
     */
    private static Collection<Integer> _getRepeated(List<Integer> numbers) {

        return numbers.stream()
                .parallel()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .collect(Collectors.toSet());
    }

    private static List<Integer> createNumbersList() {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        Random _random = new Random();

        for (int i = 0; i < NUMBERS_LIST_SIZE; i++) {
            numbers.add(random.nextInt());
            numbers.add(_random.nextInt());
        }

        return numbers;
    }
}
