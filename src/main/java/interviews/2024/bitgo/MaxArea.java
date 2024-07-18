package interviews.bitgo;

public class MaxArea {
    /* A non-negative integer array is given, where each element represents height of a 1 unit wide bar.
    * Calculate and return the max area formed by these bars.
    *
    * Input 1: [5, 6, 7, 4, 1]
    *
    * Output 1: 16
    * (From 1st to 4th bar, they form the max area of 16 = 4(height of smallest bar) * 4(distance b/w the bars))
    *
    * Input 2: [6, 3, 1, 4, 12, 4]
    *
    * Output 2: 12
    * (From bar 4th to 6th, they form the max area 12 = 4(height of the smallest bar) * 3(distance b/w the bars))
    * */

    Integer maxArea = Integer.MIN_VALUE;

    public int getSmallestHeightIndex(int[] nums, int i, int j) {
        Integer smallestElement = Integer.MAX_VALUE;
        Integer smallestElementIndex = i;

        for (int k=i; k<=j; k++) {
            if (nums[k] < smallestElement) {
                smallestElement = nums[k];
                smallestElementIndex = k;
            }
        }

        return smallestElementIndex;
    }

    public void getMaxArea(int[] nums, int i, int j) {
        if (i>j)
            return;
        int smallestHeightIndex = getSmallestHeightIndex(nums, i, j);

        maxArea = Math.max(maxArea, (j-i+1)*nums[smallestHeightIndex]);

        getMaxArea(nums, i, smallestHeightIndex-1);
        getMaxArea(nums, smallestHeightIndex+1, j);
    }

    public void printMaxArea() {
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        MaxArea area = new MaxArea();
        area.getMaxArea(new int[]{5,6,7,4,1}, 0, 4);
        area.printMaxArea();

        area = new MaxArea();
        area.getMaxArea(new int[]{6,3,1,4,12,4}, 0, 5);
        area.printMaxArea();
    }
}