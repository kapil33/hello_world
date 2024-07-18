package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfRectangles {
    /*
    Give a matrix of 1's and 0's. For example, matrix = [
                                ["1","1","1","1","1"],
                                ["1","1","0","0","1"],
                                ["1","1","0","0","1"],
                                ["1","1","1","1","1"]
                                ]

Round 1: find the rectangle that is made of 0s, either return the start and end index OR height and length of the rectangle. There is only 1 rectangle in each matrix. I solved it by looping to find the first and last zero.

Round 2: same problem but now the matrix may contains many rectangles. Return the start and end indexes of each rec in an array.

matrix = [
["0","1","1","1","1"],
["1","1","0","0","1"],
["0","1","0","0","1"],
["0","1","1","1","1"],
["1","0","1","1","1"]
] => 4 rectangles in here . 0 by itself is also a rectangle, and vertical rectangle also counts.*/

    int minRow = 0, minCol = 0;
    int maxRow = 0, maxCol = 0;

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '1')
            return;
        visited[i][j] = true;
        minRow = Math.min(minRow, i);maxRow = Math.max(maxRow, i);
        minCol = Math.min(minCol, j);maxCol = Math.max(maxCol, j);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }

    private List<List<Integer>> findRectanlges(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        /*for (int i = 0; i < rows; i++)
            Arrays.fill(visited[i], false);*/

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0' && !visited[i][j]) {
                    minRow = i;maxRow = i;
                    minCol = j;maxCol = j;
                    dfs(grid, i, j, visited);
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(maxRow - minRow + 1);
                    subResult.add(maxCol - minCol + 1);
                    result.add(new ArrayList<>(subResult));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*char[][] arr = new char[][]{
                {'0', '1', '1', '1', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}};*/

        char[][] arr = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1'}};
        NumberOfRectangles numberOfRectangles = new NumberOfRectangles();
        System.out.println(numberOfRectangles.findRectanlges(arr));
    }
}
