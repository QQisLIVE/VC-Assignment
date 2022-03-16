package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner allows input from user, int in this case
        Scanner sc = new Scanner(System.in);
        long n;          //declare n as a long since numbers get too large for int
        System.out.println("How many numbers 'n' do you wish to see?"); //Prompts the user to input a number
        n = sc.nextInt();

        System.out.println("The first " + n + " Fibonacci numbers are:");

        long startTime = System.nanoTime();
        for (long i=0; i < n; i++) {              //Adds each 'n' to a list as the output
            System.out.println(fibonacci(i));   //Prints out the list
        }
        long endTime = System.nanoTime();

        System.out.println("It took " + n + " iterations: " + (endTime - startTime) + " nanoseconds");
    }

    //Recursive function for fibonacci sequence
    public static long fibonacci(long num) {

        if (num == 0) {
            return 0;
        }
        else if(num == 1)
        {
            return 1;
        }

        return fibonacci(num-1) + fibonacci(num-2);
    }
}
