package algorithms.dp.knapsack.bounded;

public class MinimumSubsetSumDiff {

    //top down approach
    public static int minimize(int[] nums, int sum){
        int min = Integer.MAX_VALUE, n = nums.length;
        boolean[][] t = new boolean[n+1][sum+1];
        for (int j=0; j<sum+1; j++)
            t[0][j] = false;
        for (int i=0; i<n+1; i++)
            t[i][0] = true;
        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                if (nums[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] || t[i-1][j-nums[i-1]];
            }
        }

        for (int j=sum/2; j>=0; j--){
            if (t[n][j]){
                min = Math.min(min, sum-2*j);
                break;
            }
        }
        return min;
    }

    public static int minimizeWithRecursion(int[] nums, int index, int sum, int totalSum){
        if (index == 0)
            return Math.abs(totalSum - 2*sum);
        return Math.min(minimizeWithRecursion(nums, index-1, sum + nums[index-1], totalSum),
                minimizeWithRecursion(nums, index-1, sum, totalSum));
    }

    private static int sum(int[] nums){
        int sum = 0;
        for (int num: nums)
            sum += num;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimize(new int[]{1, 6, 11, 5}, sum(new int[]{1, 6, 11, 5})));
        System.out.println(minimize(new int[]{1, 2, 7}, sum(new int[]{1, 2, 7})));
        /*System.out.println(minimizeWithRecursion(new int[]{1, 6, 11, 5}, 4, 0,
                sum(new int[]{1, 6, 11, 5})));
        System.out.println(minimizeWithRecursion(new int[]{1, 2, 7}, 3, 0,
                sum(new int[]{1, 2, 7})));*/
    }
}
