package algorithms.recursion.easy;

public class isArraySorted {
    public static boolean isSorted(int[] nums, int size){
        if (size <= 1)
            return true;

        return (nums[size-1] >= nums[size-2]) && isSorted(nums, size-1);
    }

    public static void main(String[] args){
        System.out.println(isSorted(new int[]{1,2,4,5,6}, 5));
        System.out.println(isSorted(new int[]{1,3,2,4,5,6}, 6));
    }
}
