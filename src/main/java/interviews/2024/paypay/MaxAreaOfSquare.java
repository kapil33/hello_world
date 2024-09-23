package interviews.paypay;

import java.util.Stack;

public class MaxAreaOfSquare {
    /*
    * Problem Statement: A histogram is a bar graph which groups ranges of outcomes into bars of equal widths along the x-axis.
    * Imagine a grid containing a histogram which is represented by an integer array of bar heights. All the bars have width 1 and consecutive bars
    * are right next to each other w/o any gaps in between the bars.
    * Task is to find the largest square that can cover the most area within the bars of the histogram.
    *
    * Input 1: [1,2,3,2,1]
    * Output 1: 4
    *
    * Input 2: [4,3,4]
     * Output 2: 9
    * */


    public int getMaxAreaForRectangle(int[] histogram) {
        Stack<Integer> s = new Stack<>();
        int top, i=0, maxArea=Integer.MIN_VALUE, n=histogram.length;

        while (i < n) {
            if (s.isEmpty() || histogram[s.peek()] <= histogram[i])
                s.push(i++);
            else {
                top = s.pop();

                int area = histogram[top] * (s.isEmpty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!s.isEmpty()) {
            top = s.pop();
            int area = histogram[top] * (s.isEmpty() ? i : i - s.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    /*Above algo does not work for a square*/
    public int getMaxAreaForSquare(int[] histogram) {
        Stack<Integer> s = new Stack<>();
        int top, i=0, maxArea=Integer.MIN_VALUE, n=histogram.length;

        while (i < n) {
            if (s.isEmpty() || histogram[s.peek()] <= histogram[i])
                s.push(i++);
            else {
                top = s.pop();
                int width = s.isEmpty() ? i : i - s.peek() - 1;

                if (histogram[top] == width)
                    maxArea = Math.max(maxArea, histogram[top] * width);
            }
        }
        while (!s.isEmpty()) {
            top = s.pop();
            int width = s.isEmpty() ? i : i - s.peek() - 1;

            if (histogram[top] == width)
                maxArea = Math.max(maxArea, histogram[top] * width);
        }

        return maxArea;
    }

    public int findSmallest(int[] nums, int i, int j) {
        int smallest = nums[i];

        for (int k=i+1; k<=j; k++) {
            smallest = Math.min(smallest, nums[k]);
        }

        return smallest;
    }

    /*TC: O(n^2) | this is not time efficient */
    public int getMaxAreaForSquareTwo(int[] histogram) {
        int maxArea = Integer.MIN_VALUE;

        for (int i=0; i<histogram.length; i++) {
            for (int j=i; j<histogram.length; j++) {
                int smallest = findSmallest(histogram, i, j);

                if (smallest >= j-i+1)
                    maxArea = Math.max(maxArea, (j-i+1) * (j-i+1));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfSquare ms = new MaxAreaOfSquare();
        int[] histogram = new int[]{1, 2, 3, 2, 1};
        int[] histogram2 = new int[]{4, 3, 4};
        int[] histogram3 = new int[]{6, 2, 5, 4, 5, 1, 6};

        System.out.println(ms.getMaxAreaForRectangle(histogram));
        System.out.println(ms.getMaxAreaForRectangle(histogram2));
        System.out.println(ms.getMaxAreaForRectangle(histogram3));

        System.out.println("\n********************\n");

        System.out.println(ms.getMaxAreaForSquare(histogram));
        System.out.println(ms.getMaxAreaForSquare(histogram2));
        System.out.println(ms.getMaxAreaForSquare(histogram3));

        System.out.println("\n********************\n");

        System.out.println(ms.getMaxAreaForSquareTwo(histogram));
        System.out.println(ms.getMaxAreaForSquareTwo(histogram2));
        System.out.println(ms.getMaxAreaForSquareTwo(histogram3));
    }
}