package interviews.twentytwentyone.ongrid;

public class SmallestPositiveNumber {
    /*Problem Statement: given an integer array consisting of +ve and -ve numbers.
    Return the smallest positive number.
    * */
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int smallestPositive(int[] nums){
        int i=0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] > 0) {
                swap(nums, i, j);
                if (i != j)
                    i = j;
                else
                    i++;
            }
        }
        int size = i;
        for (i=0; i<size; i++){
            int index = Math.abs(nums[i])-1;
            if (index < size)
                nums[index] = -nums[index];
        }
        for (i=0; i<size; i++){
            if (nums[i] > 0)
                return i+1;
        }
        return size+1;
    }

    public static void main(String[] args) {
        System.out.println(smallestPositive(new int[]{2,-1,1,4,-10}));
        System.out.println(smallestPositive(new int[]{1,2,3}));
        System.out.println(smallestPositive(new int[]{2,4,2}));
        System.out.println(smallestPositive(new int[]{-1,0,-2}));
        System.out.println(smallestPositive(new int[]{5,3,2,1}));
    }
}
