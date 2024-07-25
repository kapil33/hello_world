package algorithms.kadanes;

import java.util.HashMap;
import java.util.Map;

public class EqualOccurrencesTwo {
    /*
    Given an array arr[] of size n containing 0 and 1 only.
    The problem is to count the subarrays having an equal number of 0’s and 1’s.

    Examples:
    Input: arr[] = {1, 0, 0, 1, 0, 1, 1}
    Output: 8
    Explanation: The index range for the 8 sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), (4, 5)(2, 5), (0, 5), (1, 6)

    Input: arr = { 1, 0, 0, 1, 1, 0, 0, 1}
    Output: 12
*/

    public static int countSubArrays(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int sum=0, totalSubArray=0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                nums[i]=-1;

            sum += nums[i];
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        for (int key: countMap.keySet()) {
            int count = countMap.get(key);
            if (count > 1) {
                totalSubArray += (count) * (count-1) / 2;
            }
        }

        return totalSubArray;
    }

    public static void main(String[] args) {
        System.out.println(countSubArrays(new int[]{1, 0, 0, 1, 0, 1, 1}));
        System.out.println(countSubArrays(new int[]{1, 0, 0, 1, 1, 0, 0, 1}));
        System.out.println(countSubArrays(new int[]{1, 0, 0, 1, 0, 1, 1}));
    }
}
