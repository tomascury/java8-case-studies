package com.java.cases.com.java.cases.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class EvenNumberSearch {

    private static Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> element -> element > pivot;

    private static Function<Integer, Integer> doubleIt = element -> element * 2;

    public static int doubleFirstEvenNumberGreaterThan(int number, List<Integer> values) {

        /**
         * Java 7
         * for (int e : values) {
         *      if (e > number && e % 2 == 0) {
         *          return e * 2;
         *      }
         * }
         * return 0;
         */


        /**
         * Java 8
         *
         * "First, the Streams API makes use of several techniques such as laziness and short-circuiting to optimize your
         *  data processing queries. Second, streams can be parallelized automatically to leverage multicore architectures."
         *
         *  @see <a href="https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html">Processing Data with Java SE 8 Streams, Part 1</a>
         */

        Optional<Integer> result = values.stream()
                .filter(isGreaterThan.apply(number))
                .filter(EvenNumberSearch::isEven)
                .map(doubleIt)
                .findFirst();

        return result.isPresent() ? result.get() : 0;
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(doubleFirstEvenNumberGreaterThan(3, values));
    }
}
