package algorithms.recursion.easy;

import java.util.Arrays;

public class ReverseArray {

    public static void reverse(int[] nums, int start, int end){
        if(start >= end)
            return;
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverse(nums, start+1, end-1);
    }

    public static void main(String[] args){
        int[] nums = {4, 2, 9, 6, 7, 1};
        reverse(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
