package algorithms.dp.knapsack.bounded;

public class CountSubsetSum {
    /*Problem Statement:
    Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
        Examples:
        Input: arr[] = {1, 2, 3, 3}, X = 6
        Output: 3
        All the possible subsets are {1, 2, 3},
        {1, 2, 3} and {3, 3}


        Input: arr[] = {1, 1, 1, 1}, X = 1
        Output: 4
    * */

    //top down approach
    private static int count(int[] nums, int n, int target){
        int[][] t = new int[n+1][target+1];
        for (int j=0; j<target+1; j++)
            t[0][j] = 0;
        for (int i=0; i<n+1; i++)
            t[i][0] = 1;
        for (int i=1; i<n+1; i++){
            for (int j=1; j<target+1; j++){
                if (nums[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
            }
        }
        return t[n][target];
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3, 3}, 4, 6));
        System.out.println(count(new int[]{1, 1, 1, 1}, 4, 1));
        System.out.println(count(new int[]{2, 3, 5, 6, 8, 10}, 6, 10));
        System.out.println(count(new int[]{1, 1, 1, 1, 1}, 5, 3));
    }
}
