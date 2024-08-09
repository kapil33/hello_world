package interviews.flipkart;

public class MatrixTraversal {
    /*Problem Statement: given a binary matrix, count the number of non-boundary 1s
    which are not directly or indirectly reachable from boundary 1s
    * Example:
    * 1 0 0 0 0
    * 0 1 1 1 0
    * 1 0 0 1 0
    * 0 1 0 1 0
    * 1 0 0 1 0
    *
    * Count: 1 (1 at index [3,1] is not reachable from any boundary 1)
    * */

    public static void traverse(int[][] matrix, boolean[][] visited, int row, int column) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[row].length) {
            return;
        }
        if (matrix[row][column] == 0 || visited[row][column]) {
            return;
        }

        visited[row][column] = true;
        traverse(matrix, visited, row+1, column);
        traverse(matrix, visited, row, column+1);
        traverse(matrix, visited, row-1, column);
        traverse(matrix, visited, row, column-1);
    }

    public static int countNonReachableOnes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (i==0 || i==matrix.length-1 || j==0 || j==matrix[i].length-1) {
                    traverse(matrix, visited, i, j);
                }
            }
        }

        int count=0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
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
        System.out.println(countNonReachableOnes(inputMatrix));
    }
}
