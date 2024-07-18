package algorithms.recursion.medium;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class MinimumJumps {

    /*
    * refer LeetCode question: "45. Jump Game II"
     * */

    Map<Integer, Integer> memo = new HashMap<>();
    public int minJumps(int[] nums, int index){
        if (index >= nums.length-1)
            return 0;
        if (nums[index] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        if(!memo.containsKey(index)) {
            for (int i = 1; i <= nums[index]; i++) {
                int jump = minJumps(nums, index + i);
                if (min > jump)
                    min = jump + 1;
            }
            memo.put(index, min);
        }

        return memo.get(index);
    }

    public int minJumpsTwo(int[] nums) {
        if (nums.length == 0)
            return 0;
        int jumps=0, currFarthest=0, currEnd=0;

        for (int i=0; i<nums.length; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                currEnd = currFarthest;
                jumps++;
                if (currEnd >= nums.length-1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args){
        MinimumJumps minimumJumps = new MinimumJumps();

        int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums3 = {2, 1, 8};
        int[] nums4 = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int[] nums5 = {1, 3, 6, 1, 0, 9};
        int[] nums6 = {2, 3, 0, 1, 4};

        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums, 0));
        minimumJumps = new MinimumJumps();
        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums2, 0));
        minimumJumps = new MinimumJumps();
        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums3, 0));
        minimumJumps = new MinimumJumps();
        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums4, 0));
        minimumJumps = new MinimumJumps();
        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums5, 0));
        minimumJumps = new MinimumJumps();
        System.out.println("Minimum steps are: " + minimumJumps.minJumps(nums6, 0));

        System.out.println("\n**********************\n");

        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums));
        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums2));
        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums3));
        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums4));
        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums5));
        System.out.println("Minimum steps are: " + minimumJumps.minJumpsTwo(nums6));
    }
}
