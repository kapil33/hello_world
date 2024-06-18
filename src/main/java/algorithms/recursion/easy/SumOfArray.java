package algorithms.recursion.easy;

public class SumOfArray {

    public static int sum(int[] nums, int index){
        if (index >= nums.length)
            return 0;

        return nums[index] + sum(nums, index+1);
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(nums, 0));
    }
}
