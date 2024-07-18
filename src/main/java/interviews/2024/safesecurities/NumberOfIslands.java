package interviews.SafeSecurities;

public class NumberOfIslands {
    /*Given a nXm binary grid, where 1 is land and 0 is water. Find the number of islands present in this grid.
    *
    * Input 1:
    *           {1,1,1,0,0},
                {1,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
      Output 1:
      *     1
      *
      * Input 2:
      *         {1,1,1,0,0},
                {1,1,0,0,0},
                {1,0,1,1,0},
                {0,0,1,1,0},
                {1,0,0,0,0}
        Output 2:
        *   3
    * */

    public void markVisitedLand(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        markVisitedLand(grid, visited, i+1, j);
        markVisitedLand(grid, visited, i-1, j);
        markVisitedLand(grid, visited, i, j+1);
        markVisitedLand(grid, visited, i, j-1);
    }

    public int getNumberOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count=0, rows=grid.length, cols=grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    markVisitedLand(grid, visited, i, j);
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[][] grid1 = new int[][] {
                {1,1,1,0,0},
                {1,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int[][] grid2 = new int[][] {
                {1,1,1,0,0},
                {1,1,0,0,0},
                {1,0,1,1,0},
                {0,0,1,1,0},
                {1,0,0,0,0}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        System.out.println(numberOfIslands.getNumberOfIslands(grid1));
        System.out.println(numberOfIslands.getNumberOfIslands(grid2));
    }
}