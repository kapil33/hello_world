package algorithms.dp.knapsack.bounded;

public class KEqualSumSubset {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum % k != 0 || k <= 0)
            return false;
        return check(nums, 0, new boolean[nums.length], k,0, sum/k);
    }

    private static boolean check(int[] nums, int index, boolean[] visited, int k, int sum, int target) {
        if (k == 0)
            return true;
        if (sum > target)
            return false;
        if (sum == target)
            return check(nums, 0, visited, k-1, 0, target);
        for (int i=index; i<nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                if (check(nums, i+1, visited, k, sum+nums[i], target))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }
}
