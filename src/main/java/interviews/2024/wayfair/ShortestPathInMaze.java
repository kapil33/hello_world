package interviews.wayfair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
    /*
    * Problem Statement: there is a maze represented as n*m grid of cells, where each cell is either empty(denoted by 0)
    * , or contains an obstacle(denoted by 1). You start at (0, 0) and wish to reach (n-1, m-1).
    *
    * For a jump parameter denoted by k, in one move, you can move to any of the following cells:
    * 1. (i+x, j) where 1 <= x <= k, provided cell (i+x, j) lies in the maze and there are no cells containing
    * obstacles in the range (i+1, j) -> (i+x, j)
    * 2. (i,j+x)
    * 3. (i-x, j)
    * 4. (i, j-x)
    * */

    public int getShortestPath(int[][] maze, int k) {
        if (maze[0][0] == 1)
            return -1;
        int row=maze.length, col=maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int res=0;
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int w=0; w<size; w++) {
                int[] coor = q.poll();
                int i=coor[0], j=coor[1];

                if (i == row-1 && j == col-1)
                    return res;

                for (int z=1; z<=k; z++) {
                    if (i+z < row && maze[i+z][j] == 1) // to make sure that you don't jump over the obstacle
                        break;
                    if (i+z < row && maze[i+z][j] == 0 && !visited[i+z][j]) {
                        q.add(new int[]{i+z, j});
                        visited[i+z][j] = true;
                    }
                }
                for (int z=1; z<=k; z++) {
                    if (i-z >= 0 && maze[i-z][j] == 1)
                        break;
                    if (i-z >= 0 && maze[i-z][j] == 0 && !visited[i-z][j]) {
                        q.add(new int[]{i-z, j});
                        visited[i-z][j] = true;
                    }
                }
                for (int z=1; z<=k; z++) {
                    if (j+z < col && maze[i][j+z] == 1)
                        break;
                    if (j+z < col && maze[i][j+z] == 0 && !visited[i][j+z]) {
                        q.add(new int[]{i, j+z});
                        visited[i][j+z] = true;
                    }
                }
                for (int z=1; z<=k; z++) {
                    if (j-z >= 0 &&maze[i][j-z] == 1)
                        break;
                    if (j-z >= 0 && maze[i][j-z] == 0 && !visited[i][j-z]) {
                        q.add(new int[]{i, j-z});
                        visited[i][j-z] = true;
                    }
                }
            }

            res++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInMaze spim = new ShortestPathInMaze();
        int[][] maze = new int[][]{
                {0,0,0},
                {1,0,0}};
        System.out.println(spim.getShortestPath(maze, 5));

        maze = new int[][] {
                {0,0,1,0},
                {1,0,1,0},
                {0,0,0,0},
                {0,1,0,0}};
        System.out.println(spim.getShortestPath(maze, 4));
        maze = new int[][] {
                {0,0,0,0},
                {1,0,1,0},
                {0,0,0,0},
                {0,1,0,0}};
        System.out.println(spim.getShortestPath(maze, 4));

        maze = new int[][] {
                {0,0,1,0},
                {1,0,1,0},
                {0,0,1,0},
                {0,1,0,0}};
        System.out.println(spim.getShortestPath(maze, 4));

        maze = new int[][]{{1,0,0}, {0,0,0}};
        System.out.println(spim.getShortestPath(maze, 2));

        maze = new int[][]{{0,0,0}, {1,0,1}};
        System.out.println(spim.getShortestPath(maze, 2));
    }
}