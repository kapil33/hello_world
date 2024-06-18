package algorithms.recursion.easy;

public class BinarySearch {

    public static int binarySearch(int[] nums, int start, int end, int target){
        if (start > end)
            return -1;

       int mid = start + (end-start)/2;

       if (nums[mid] == target)
           return mid;
       else if(target > nums[mid])
           return binarySearch(nums, mid+1, end, target);
       else
           return binarySearch(nums, start, mid-1, target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 9};
        int ans = binarySearch(nums, 0, nums.length - 1, 7);

        if (ans != -1)
            System.out.println("Found at index: " + ans);
        else
            System.out.println("Could not find");
    }
}
