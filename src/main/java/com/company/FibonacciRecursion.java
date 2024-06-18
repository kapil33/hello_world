package com.company;

import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursion {

    public static void main(String[] args){
        int result = fibo(7);

        System.out.println("result: " + result + " " + Math.pow(1.6180, 6));
    }

    /*
    * This problem is exactly similar to staircase problem
    * in interviews they never ask fibonacci, they ask twisted question which implies fibonacci internally
    *
    * */


    public static int fibo(int num){
        if (num <= 1)
            return num;
        int f1 = 1;
        int f2 = 0;

        for (int i = 2; i <= num; i++){
            int f = f1 + f2;
            f2 = f1;
            f1 = f;
        }
        return f1;
    }
}


























/*
Solution 1: Recursive w/o caching {time complexity: e^n}
public static int fibo(int num){
        if (num <= 1)
            return num;

        return fibo(num-1) + fibo(num-2);
    }

Solution 2: recursive with caching {time: O(n) & space: O(n)}
public static Map<Integer, Integer> cache = new HashMap<>();
public static int fibo(int num){
        if (num <= 1)
            return num;
        else if (!cache.containsKey(num))
            cache.put(num, fibo(num-1) + fibo(num-2));

        return cache.get(num);
    }

solution 3: iterative {time: O(n) & space: O(1)}
public static int fibo(int num){
        if (num <= 1)
            return num;

        int fminus1 = 1;
        int fminus2 = 0;
        for (int i=2; i<=num; i++){
            int f = fminus1 + fminus2;
            fminus2 = fminus1;
            fminus1 = f;
        }
        return fminus1;
    }
**/
