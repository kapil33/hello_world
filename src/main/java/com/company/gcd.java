package com.company;

public class gcd {

    public static void main(String[] args){
        System.out.println("Result id: " + gcdCalc(156, 36));
        return;
    }

    public static int gcdCalc(int y, int x){

        return (x == 0) ? y : gcdCalc(x, y % x);
    }
}








/*Solution 1:
public static int gcdCalc(int y, int x){
        if (y % x == 0)
            return x;
        return gcdCalc(x, y % x);
    }

Solution 2:

* */