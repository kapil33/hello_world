package com.company;

public class RecursiveBinarySearch {

    public boolean binarySearch(int[] nums, int first, int last, int target){

        if(first <= last) {
            int mid = first + (last - first) / 2;

            if (target == nums[mid])
                return true;
            else if (target > nums[mid])
                return binarySearch(nums, mid + 1, last, target);
            else
                return binarySearch(nums, first, mid - 1, target);
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RecursiveBinarySearch rbs = new RecursiveBinarySearch();

        System.out.println("found it: " + rbs.binarySearch(arr, 0, arr.length-1, 2));
    }
}
