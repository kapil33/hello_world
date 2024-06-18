package algorithms.recursion.medium;

import javafx.util.Pair;
import java.util.HashMap;

public class MinimumJumps {

    /*
    * refer LeetCode question: "45. Jump Game II"
     * */

    static HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    public static int minJumps(int[] nums, int index){
        if (index >= nums.length-1)
            return 0;
        if (nums[index] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        if(!memo.containsKey(new Pair<>(index, nums[index]))) {
            for (int i = 1; i <= nums[index]; i++) {
                int jump = minJumps(nums, index + i);
                if (min > jump)
                    min = jump + 1;
            }
            memo.put(new Pair<>(index, nums[index]), min);
        }

        return memo.get(new Pair<>(index, nums[index]));
    }

    public static void main(String[] args){
        int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums3 = {2, 1, 8};
        int[] nums4 = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int[] nums5 = {1, 3, 6, 1, 0, 9};
        int[] nums6 = {2, 3, 0, 1, 4};
        System.out.println("Minimum steps are: " + minJumps(nums4, 0));
    }
}
