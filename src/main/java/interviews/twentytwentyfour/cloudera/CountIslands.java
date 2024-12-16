package interviews.twentytwentyfour.cloudera;

public class CountIslands {
    /*
    * Problem Statement: you are given a binary grid where 1 represents land and 0 represents water.
    * Output the no. of unconnected islands present in this grid.
    * */

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int row = grid.length, col = grid[0].length;
        if (i<0 || i>=row || j<0 || j>=col || grid[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }

    public int countIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length, count=0;
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0,0,},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}};

        CountIslands cl = new CountIslands();
        System.out.println(cl.countIslands(grid));
    }

}
