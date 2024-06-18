package algorithms.recursion.medium;

import java.util.Arrays;

public class SortArray {

    public static void sort(int[] nums, int size){
        if (size <= 1)
            return;

        for (int i=0; i<size-1; i++){
            if (nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }

        sort(nums, size-1);
    }

    public static void main(String[] args){
        int[] nums = new int[]{4, 2, 9, 6, 7, 1};
        sort(nums, 6);
        System.out.println(Arrays.toString(nums));
    }
}
