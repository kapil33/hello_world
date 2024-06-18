package algorithms.dp.knapsack.unbounded;

public class RodCuttingProblem {
    /*Problem Statement: Given a rod of length n inches and an array of prices that
    contains prices of all pieces of size smaller than n. Determine the  maximum value
    obtainable by cutting up the rod and selling the pieces.

    Example: if length of the rod is 8 and the values of different pieces are given as following,
    then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
        length   | 1   2   3   4   5   6   7   8
        --------------------------------------------
        price    | 1   5   8   9  10  17  17  20
*/

    //top down approach
    public static int maximizeWithTopDown(int n, int[] price){
        int[] length = new int[n];
        for (int i=0; i<n; i++)
            length[i] = i+1;
        int[][] t = new int[n+1][n+1];
        //initialization
        for (int i=0; i<n+1; i++){
            for (int j=0; j<n+1; j++){
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if(length[i-1] <= j)
                    t[i][j] = Math.max(
                            price[i-1] + t[i][j-length[i-1]],
                            t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][n];
    }

    //recursive
    public static int maximize(int n, int[] price, int totalLength) {
        if (n == 0 || totalLength == 0)
            return 0;
        if (n <= totalLength)
            return Math.max(
                    price[n-1] + maximize( n, price, totalLength-n),
                    maximize( n-1, price, totalLength));
        return maximize(n-1, price, totalLength);
    }

    public static void main(String[] args) {
        System.out.println(maximize(8, new int[]{1,5,8,9,10,17,17,20}, 8));
        System.out.println(maximize(8, new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));
        System.out.println(maximizeWithTopDown(8, new int[]{1,5,8,9,10,17,17,20}));
        System.out.println(maximizeWithTopDown(8, new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
    }
}
