package algorithms.dp.knapsack.unbounded;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {
    /*You are given coins of different denominations, return minimum coins needed to achieve the given sum
     *
     * Input 1: {1, 2, 3} ,  sum = 5
     *
     * Output 1: 2 {all the ways: {1,2,2}, {1,1,1,2}, {2,3}, {1,1,3}, {1,1,1,1,1}}
     * */

    public int solveWithDP(int[] nums, int k, int sum) {
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];

        for (int i=0; i<sum+1; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i=1; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for (int i=1; i<sum+1; i++) {
            if (i % nums[0] == 0)
                dp[1][i] = i/nums[0];
            else
                dp[1][i] = Integer.MAX_VALUE-1;
        }

        for (int i=2; i<n+1; i++) {
            for (int j=1; j<sum+1; j++) {
                dp[i][j] = dp[i-1][j];

                if (nums[i-1] <= j)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - nums[i-1]]);
            }
        }

        return dp[n][sum];
    }

    public int solveWithDP(int[] nums, int sum) {
        int res = solveWithDP(nums, 0, sum);

        return res != Integer.MAX_VALUE-1 ? res:-1;
    }

    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

    /*Below algorithm gives wrong answer*/
    public int solveWithMemo(int[] nums, int i, int sum) {
        /*if (sum == 0)
            return 0;
        if (i >= nums.length || sum < 0)
            return Integer.MAX_VALUE-1;

        Pair<Integer, Integer> key = new Pair<>(i, sum);
        if (!memo.containsKey(key)) {
            if (nums[i] > sum)
                memo.put(key, solveWithMemo(nums, i+1, sum));
            else
                memo.put(key, Math.min(solveWithMemo(nums, i+1, sum), 1 + solveWithMemo(nums, i, sum - nums[i])));
        }

        return memo.get(key);*/
        if(sum == 0)
            return 0;
        if(i >= nums.length || sum < 0)
            return Integer.MAX_VALUE-1;

        if(!memo.containsKey(new Pair<>(i, sum))){
            if(nums[i] > sum)
                memo.put(new Pair<>(i, sum), solveWithMemo(nums, i+1, sum));
            else
                memo.put(new Pair<>(i, sum),
                        Math.min(solveWithMemo(nums, i+1, sum), 1 + solveWithMemo(nums, i, sum - nums[i])));
        }

        return memo.get(new Pair<>(i, sum));
    }

    public int solveWithMemo(int[] nums, int sum) {
        int res = solveWithMemo(nums, 0, sum);

        return res != Integer.MAX_VALUE-1 ? res:-1;
    }

    public int solve(int[] nums, int i, int sum) {
        if (sum == 0)
            return 0;
        if (i >= nums.length || sum < 0)
            return Integer.MAX_VALUE-1;

        if (nums[i] > sum)
            return solve(nums, i+1, sum);
        else
            return Math.min(solve(nums, i+1, sum), 1 + solve(nums, i, sum - nums[i]));
    }

    public int solve(int[] nums, int sum) {
        int res = solve(nums, 0, sum);

        return res != Integer.MAX_VALUE-1 ? res:-1;
    }

    public static void main(String[] args) {
        CoinChange2 cc = new CoinChange2();
        int[] coins = new int[]{1,2,3};
        int[] coins2 = new int[]{1,2,5};

        System.out.println(cc.solve(coins, 5));
        System.out.println(cc.solve(coins2, 11));

        System.out.println("\n*************\n");

        System.out.println(cc.solveWithMemo(coins, 5));
        System.out.println(cc.solveWithMemo(coins2, 11));

        System.out.println("\n*************\n");

        System.out.println(cc.solveWithDP(coins, 5));
        System.out.println(cc.solveWithDP(coins2, 11));
    }
}
