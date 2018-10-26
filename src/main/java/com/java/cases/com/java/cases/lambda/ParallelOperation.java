package com.java.cases.com.java.cases.lambda;

import java.util.ArrayList;
import java.util.List;

public class ParallelOperation {

    public static int sum(List<Integer> values){

        return values.stream()
               .mapToInt(ParallelOperation::doubleIt)
               .sum();
    }

    public static int sumParallel(List<Integer> values){

        return values.parallelStream()
                .mapToInt(ParallelOperation::doubleIt)
                .sum();
    }

    public static int doubleIt(int number){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }

    public static void main(String[] args){

        List<Integer> values = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            values.add(i);
        }
        long startTime = System.currentTimeMillis();
        System.out.println(sum(values));
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Sum Time: " + totalTime / 1000 + "s");

        startTime = System.currentTimeMillis();
        System.out.println(sumParallel(values));
        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Sum Parallel Time: " + totalTime / 1000 + "s");
    }
}
