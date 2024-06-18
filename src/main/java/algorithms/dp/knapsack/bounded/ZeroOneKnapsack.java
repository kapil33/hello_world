package algorithms.dp.knapsack.bounded;

import java.util.Arrays;

public class ZeroOneKnapsack {
    /*Problem Statement: You are given weight of n elements and their corresponding values. You are also given a
    knapsack with a maximum capacity. You need to maximize the value that the knapsack can hold.
    For Example: weight[]: [1,3,4,5] , value[]: [1,4,5,7] , weight=7
    * */

    //top down approach
    public static int maximizeWithTopDown(int[] weight, int[] value, int n, int w){
        int[][] t = new int[n+1][w+1];
        //initialization
        for (int i=0; i<n+1; i++){
            for (int j=0; j<w+1; j++){
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if(weight[i-1] <= j)
                    t[i][j] = Math.max(
                            value[i-1] + t[i-1][j-weight[i-1]],
                            t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][w];
    }

    //recursion with memoization
    static int[][] t = new int[1000][1000]; //size of this matrix would be dependent on constraints of n & w
    public static int maximizeWithMemoize(int[] weight, int[] value, int n, int w){
        if (n == 0 || w == 0)
            return 0;
        if (t[n][w] != -1)
            return t[n][w];
        if (weight[n-1] <= w)
            return t[n][w] = Math.max(
                    value[n-1] + maximizeWithMemoize(weight, value, n-1, w-weight[n-1]),
                    maximizeWithMemoize(weight, value, n-1, w));
        return t[n][w] = maximizeWithMemoize(weight, value, n-1, w);
    }

    //using recursion
    public static int maximize(int[] weight, int[] value, int n, int w) {
        if (n == 0 || w == 0)
            return 0;
        if (weight[n-1] <= w)
            return Math.max(
                    value[n-1] + maximize(weight, value, n-1, w-weight[n-1]),
                    maximize(weight, value, n-1, w));
        return maximize(weight, value, n-1, w);
    }

    public static void main(String[] args) {
        //System.out.println(maximize(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 4, 7));
        /*for (int i=0; i<t.length; i++)
            Arrays.fill(t[i], -1);
        System.out.println(maximizeWithMemoize(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 4, 7));
        System.out.println(maximizeWithMemoize(new int[]{10,3,4,5}, new int[]{100,4,5,7}, 4, 10));*/
        System.out.println(maximizeWithTopDown(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 4, 7));
        System.out.println(maximizeWithTopDown(new int[]{10,3,4,5}, new int[]{100,4,5,7}, 4, 10));
    }
}
