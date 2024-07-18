package interviews.flipkart;

public class MatrixTraversal {
    /*Problem Statement: given a binary matrix, count the number of non-boundary 1s which are not directly or indirectly reachable from boundary 1s
    * Example:
    * 1 0 0 0 0
    * 0 1 1 1 0
    * 1 0 0 1 0
    * 0 1 0 1 0
    * 1 0 0 1 0
    *
    * Count: 1 (1 at index [3,1] is not reachable from any boundary 1)
    * */

    public static void trav(int[][] nums, int[][] reachable, int row, int col){
        if (row < 0 || row >= nums.length || col < 0 || col >= nums[0].length)
            return;
        if(nums[row][col] == 0 || reachable[row][col] == 1)
            return;
        reachable[row][col] = 1;
        trav(nums, reachable, row-1, col);
        trav(nums, reachable, row+1, col);
        trav(nums,reachable, row, col-1);
        trav(nums, reachable, row, col+1);
    }

    public static int count(int[][] nums, int[][] reachable){
        int rows = nums.length, cols = nums[0].length;
        for (int i=0; i<cols; i++){
            //for 1st row
            trav(nums, reachable, 0, i);
            //for last row
            trav(nums, reachable, rows-1, i);
        }
        for (int i=0; i<rows; i++){
            //for 1st col
            trav(nums, reachable, i, 0);
            //for last col
            trav(nums, reachable, i, cols-1);
        }
        int count = 0;
        for (int i=1; i<rows-1; i++){
            for (int j=1; j<cols-1; j++){
                if (nums[i][j] == 1 && reachable[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //input 1
        int[][] inputMatrix = new int[][]{
                {1,0,0,0,0},
                {0,1,1,1,0},
                {1,0,0,1,0},
                {0,1,0,1,0},
                {1,0,0,1,0}
        };

        //input 2
        /*int[][] inputMatrix = new int[][]{
                {1,1,0,0,0},
                {0,1,0,0,0},
                {1,0,0,1,0},
                {0,1,0,0,0},
                {1,0,0,1,0}
        };*/

        //input 3
        /*int[][] inputMatrix = new int[][]{
                {1,1,0,0,0},
                {0,0,1,1,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {1,0,0,1,0}
        };*/
        int[][] reachable = new int[inputMatrix.length][inputMatrix[0].length];
        System.out.println(count(inputMatrix, reachable));
    }
}
