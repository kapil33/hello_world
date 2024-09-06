package algorithms.dp.knapsack.unbounded;

public class CoinChange1 {
    /*You are given coins of different denominations, return max no. of ways to achieve the given sum
    *
    * Input 1: {1, 2, 3} ,  sum = 5
    *
    * Output 1: 5 {{1,2,2}, {1,1,1,2}, {2,3}, {1,1,3}, {1,1,1,1,1}}
    * */

    public int solveWithTopDown(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i=0; i<sum+1; i++) {
            dp[0][i] = 0;
        }
        for (int i=0; i<n+1; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<sum+1; j++) {
                dp[i][j] = dp[i-1][j];

                if (nums[i-1] <= j)
                    dp[i][j] += dp[i][j - nums[i-1]];
            }
        }

        return dp[n][sum];
    }

    public int solve(int[] nums, int i, int sum) {
        if (sum == 0)
            return 1;
        if (i >= nums.length)
            return 0;

        int count  = solve(nums, i+1, sum);
        if (nums[i] <= sum)
            count += solve(nums, i, sum - nums[i]);

        return count;
    }

    public static void main(String[] args) {
        CoinChange1 cc = new CoinChange1();
        int[] coins = new int[]{1,2,3};

        System.out.println(cc.solve(coins, 0, 5));
        System.out.println(cc.solve(coins, 0, 10));

        System.out.println("\n*************\n");

        System.out.println(cc.solveWithTopDown(coins, 5));
        System.out.println(cc.solveWithTopDown(coins, 10));
    }
}
