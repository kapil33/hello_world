package interviews.twentytwentyfour.bitgo;

/*Given an array of integers, return maximum sum of non-adjacent elements.

Input 1: nums = [1, 2, 3, 1, 4]
Output 1: 8
explanation: 1 + 3 + 4 = 8

Input 2: nums = [4, 1, 1, 5]
Output 2: 9
explanation: 4 + 5 = 9
*/


import java.util.HashMap;
import java.util.Map;

public class MaxNonAdjacentSum {

    /*Recursive solution*/
    public int calcMaxSum(int[] nums, int i) {
        if (i >= nums.length)
            return 0;

        return Math.max(nums[i] + calcMaxSum(nums, i+2), calcMaxSum(nums, i+1));
    }

     Map<Integer, Integer> map = new HashMap<>();

    /*DP Memoization solution*/
    public int calcMaxSumWithDpMemoization(int[] nums, int i) {
        if (i >= nums.length)
            return 0;

        if (!map.containsKey(i)) {
            map.put(i, Math.max(nums[i] + calcMaxSumWithDpMemoization(nums, i+2), calcMaxSumWithDpMemoization(nums, i+1)));
        }

        return map.get(i);
    }

    public static void main(String[] args) {
        MaxNonAdjacentSum maxNonAdjacentSum = new MaxNonAdjacentSum();

        int[] nums1 = new int[]{1, 2, 3, 1, 4};
        System.out.println(maxNonAdjacentSum.calcMaxSum(nums1, 0));

        int[] nums2 = new int[]{4, 1, 1, 5};
        System.out.println(maxNonAdjacentSum.calcMaxSum(nums2, 0));

        int[] nums3 = new int[]{1, 4, 1, 1, 5};
        System.out.println(maxNonAdjacentSum.calcMaxSum(nums3, 0));

        int[] nums4 = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(maxNonAdjacentSum.calcMaxSum(nums4, 0));

        int[] nums5 = new int[]{3, 2, 5, 10, 7};
        System.out.println(maxNonAdjacentSum.calcMaxSum(nums5, 0));

        System.out.println("\n******************\n");

        maxNonAdjacentSum = new MaxNonAdjacentSum();
        System.out.println(maxNonAdjacentSum.calcMaxSumWithDpMemoization(nums1, 0));

        maxNonAdjacentSum = new MaxNonAdjacentSum();
        System.out.println(maxNonAdjacentSum.calcMaxSumWithDpMemoization(nums2, 0));

        maxNonAdjacentSum = new MaxNonAdjacentSum();
        System.out.println(maxNonAdjacentSum.calcMaxSumWithDpMemoization(nums3, 0));

        maxNonAdjacentSum = new MaxNonAdjacentSum();
        System.out.println(maxNonAdjacentSum.calcMaxSumWithDpMemoization(nums4, 0));

        maxNonAdjacentSum = new MaxNonAdjacentSum();
        System.out.println(maxNonAdjacentSum.calcMaxSumWithDpMemoization(nums5, 0));
    }
}