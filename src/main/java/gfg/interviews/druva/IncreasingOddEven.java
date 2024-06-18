package gfg.interviews.druva;

import java.util.Arrays;

public class IncreasingOddEven {
    /*
    * PROBLEM STATEMENT:
    *
    * You are given an integer array consisting of odd and even values.
    * Return a new array consisting of alternative odd and even values in ascending order
    *
    * For Example:
    * int[] num = {5, 23, 8, 22, 9};
    * Above array becomes
    * int[] result = {5, 8, 9, 22, 23}
    * */

    public int findEven(int[] nums, int index){
        for (int i=index+1; i<nums.length; i++){
            if (nums[i] % 2 == 0)
                return i;
        }

        return -1;
    }

    public int findOdd(int[] nums, int index){
        for (int i=index+1; i<nums.length; i++){
            if (nums[i] % 2 != 0)
                return i;
        }

        return -1;
    }

    public int[] modify(int[] nums){
        int[] result = new int[nums.length];
        Arrays.sort(nums);

        int k = 0, i = findOdd(nums, -1), j = findEven(nums, -1);

        if (nums[0] % 2 != 0){
            while (k < nums.length){
                result[k++] = nums[i];
                i = findOdd(nums, i);

                if(k < nums.length)
                    result[k++] = nums[j];
                j = findEven(nums, j);
            }
        }else {
            while (k < nums.length){
                result[k++] = nums[j];
                j = findEven(nums, j);

                if(k < nums.length)
                    result[k++] = nums[i];
                i = findOdd(nums, i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {5, 7, 23, 11};
        IncreasingOddEven ioe = new IncreasingOddEven();
        System.out.println(Arrays.toString(ioe.modify(nums)));
    }
}
