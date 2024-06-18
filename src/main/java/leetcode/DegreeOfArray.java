package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class DegreeOfArray {

    public int shortestSubArray(int[] nums){
        HashMap<Integer, Integer>
                left = new HashMap<>(),
                right = new HashMap<>(),
                count = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(left.get(nums[i]) == null)
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println("left indexes:  " + left);
        System.out.println("right indexes: " + right);
        System.out.println("counts are:    " + count);

        int degree = Collections.max(count.values());
        System.out.println("degree: " + degree);
        System.out.println("count values: " + count.values());
        System.out.println("count set keys: " + count.keySet());
        int ans = nums.length;
        for (Integer val : count.keySet()/*int i=0; i<nums.length; i++*/){
            if (count.get(val) == degree)
                ans = Math.min(ans, right.get(val) - left.get(val) + 1);
        }

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,1,4,2/*2,1,1,2,1,3,3,3,1,3,1,3,2*/};
        DegreeOfArray doa = new DegreeOfArray();
        System.out.println(doa.shortestSubArray(nums));
    }
}
