package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args)

    {

        Random rand = new Random();

        //Up to 200 Million numbers
        int[] arr = new int[200000000];

        for (int i = 0; i < arr.length; i++) {
            //adding random
            arr[i] = rand.nextInt(10) + 1;

        }

        long start = System.currentTimeMillis();

        System.out.println(Summary.sum(arr));
        //Single thread timed
        System.out.println("Single Thread: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();

        System.out.println(Summary.parallelSum(arr));
        //Parallel Thread timed
        System.out.println("Parallel Thread: " + (System.currentTimeMillis() - start) + "ms");

    }
}
