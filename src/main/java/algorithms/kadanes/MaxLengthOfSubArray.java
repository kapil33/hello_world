package algorithms.kadanes;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthOfSubArray {
    /*Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s
    *
    * Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
        Output: 1 to 6
        (Starting and Ending indexes of output subarray)

        Input: arr[] = {1, 1, 1, 1}
        Output: No such subarray

        Input: arr[] = {0, 0, 1, 1, 0}
        Output: 0 to 3 Or 1 to 4
        * */

    /*brute force: time complexity: O(n^2)*/
    public static int maxLengthSubArray(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int odd=0, even=0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] % 2 == 0)
                    even++;
                else
                    odd++;
                if(even == odd && max < j-i+1){
                    max = j-i+1;
                }
            }
        }

        return max > 0 ? max:0;
    }

    /*time complexity: O(n)*/
    public static int maxLengthSubArray2(int[] nums){
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i=0; i<nums.length; i++){
            if(nums[i] == 0)
                nums[i] = -1;
            sum += nums[i];
            if (map.containsKey(sum))
                max = Math.max(max, i-map.get(sum));
            else
                map.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthSubArray2(new int[]{1, 0, 1, 1, 1, 0, 0}));
        System.out.println(maxLengthSubArray2(new int[]{1, 1, 1, 1}));
        System.out.println(maxLengthSubArray2(new int[]{0,0,1,1,0}));
    }
}
