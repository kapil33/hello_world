package algorithms.dp.knapsack.bounded;

import java.util.Arrays;

public class SubsetSumProblem {

    //top down approach
    public static boolean existsWithTopDown(int[] nums, int n, int sum){
        boolean[][] t = new boolean[n+1][sum+1];
        for(int j=0; j<sum+1; j++)
            t[0][j] = false;
        for (int i=0; i<n+1; i++)
            t[i][0] = true;
        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                if (nums[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
            }
        }
        return t[n][sum];
    }

    //with memoization
    static int[][] dp = new int[100][100];
    public static boolean existsWithMemoize(int[] nums, int n, int sum){
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (dp[n][sum] != -1)
            return dp[n][sum] == 1 ? true:false;
        if(nums[n-1] > sum) {
            boolean temp = exists(nums, n - 1, sum);
            dp[n][sum] = temp == true ? 1 : 0;
            return temp;
        }
        boolean include = exists(nums, n-1, sum-nums[n-1]);
        boolean exclude = exists(nums, n-1, sum);
        dp[n][sum] = include || exclude ? 1:0;
        return  include || exclude;
    }

    //using recursion
    public static boolean exists(int[] nums, int n, int sum){
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if(nums[n-1] > sum)
            return exists(nums, n-1, sum);
        return exists(nums, n-1, sum-nums[n-1]) || exists(nums, n-1, sum);
    }

    public static void main(String[] args) {
        /*System.out.println(exists(new int[]{2,3,7,8,10}, 5, 11));
        System.out.println(exists(new int[]{2,3,7,8,10}, 5, 14));
        System.out.println(exists(new int[]{3, 34, 4, 12, 5, 2}, 6, 9));
        System.out.println(exists(new int[]{3, 34, 4, 12, 5, 2}, 6, 30));*/
        System.out.println(existsWithTopDown(new int[]{2,3,7,8,10}, 5, 11));
        System.out.println(existsWithTopDown(new int[]{2,3,7,8,10}, 5, 14));
        System.out.println(existsWithTopDown(new int[]{3, 34, 4, 12, 5, 2}, 6, 9));
        System.out.println(existsWithTopDown(new int[]{3, 34, 4, 12, 5, 2}, 6, 30));
        /*for (int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(existsWithMemoize(new int[]{2,3,7,8,10}, 5, 11));
        System.out.println(existsWithMemoize(new int[]{2,3,7,8,10}, 5, 14));
        System.out.println(existsWithMemoize(new int[]{3, 34, 4, 12, 5, 2}, 6, 9));
        System.out.println(existsWithMemoize(new int[]{3, 34, 4, 12, 5, 2}, 6, 30));*/

    }
}
