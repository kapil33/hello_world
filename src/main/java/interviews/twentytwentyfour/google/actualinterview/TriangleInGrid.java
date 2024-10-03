package interviews.twentytwentyfour.google.actualinterview;

public class TriangleInGrid {
    /*
    * Problem Statement: You are given a binary grid of m x n, the 1's in the grid can form an
    * upside down triangle with same length and height. The task is to return the max length of a triangle.
    *
    * Input:
    * 0 0 0 1 1
    * 0 1 1 1 0
    * 0 0 1 1 0
    * 0 0 0 1 1
    *
    * Output: 3
    *
    * Algorithm:
    * 1. Start from top right corner i.e. first row last column and search for a 1
    * 2. Once you find a 1 then from there see what is the biggest triangle that can be formed
    * 3. See if this is the largest triangle found so far or not
    *
    * Assume: m = rows, n = cols
    * Approach 1(w/o optimization)-> TC: O(m*n(n + n*n)) = O(m*n^3) = O(m^4) {if m=n}
    *
    * Approach 2-> TC(with countOnes method optimized): O(m*n(1 + n*1)) = O(m*n^2) = O(m^3) {if m=n}
    * */

    public int countOnes(int[] row, int j) {
        int count = 0;

        for (int i=j; i>=0; i--) {
            if (row[i] == 1)
                count++;
            else
                break;
        }

        return count;
    }

    public int countOnesOptimized(int[] row, int j, int[] countOnesRow) {
        int count = 0;

        for (int i=j; i>=0; i--) {
            if (countOnesRow[i] != 0) {
                count += countOnesRow[i];
                break;
            }
            if (row[i] == 1)
                count++;
            else
                break;
        }

        countOnesRow[j] = count;
        return count;
    }

    public boolean isTriangle(int[][] grid, int x, int y, int len) {
        int row = grid.length, col = grid[0].length;

        if (len > row-x) // to check whether we have enough rows to make a triangle of length = len
            return false;

        for (int i=0; i<len; i++) {
            if (x+i < row && countOnes(grid[x+i], y) < len - i)
                return false;
        }

        return true;
    }

    public int findLargestTriangle(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int maxTriangleLength = Integer.MIN_VALUE;
        int[][] countOnesGrid = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=col-1; j>=0; j--) {
                if (grid[i][j] == 1) {
                    //int count = countOnes(grid[i], j);
                    int count = countOnesOptimized(grid[i], j, countOnesGrid[i]);

                    while (count > 0) {
                        if (isTriangle(grid, i, j, count)) {
                            maxTriangleLength = Math.max(maxTriangleLength, count);
                            break;
                        }
                        count--;
                    }
                }
            }
        }

        return maxTriangleLength;
    }

    public static void main(String[] args) {
        TriangleInGrid tig = new TriangleInGrid();
        int[][] grid = new int[][]{
                {0,0,0,1,1},
                {0,1,1,1,0},
                {0,0,1,1,0},
                {0,0,0,1,1}
        };
        int[][] grid2 = new int[][]{
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };
        int[][] grid3 = new int[][]{
                {0,1,0,0,1},
                {1,0,1,0,1},
                {0,1,0,1,0},
                {1,0,1,0,1}
        };

        System.out.println(tig.findLargestTriangle(grid));
        System.out.println(tig.findLargestTriangle(grid2));
        System.out.println(tig.findLargestTriangle(grid3));
    }
}