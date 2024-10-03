package interviews.twentytwentyone.indeed;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReachableMatrix {
/*
Given a board and an end position for the player, write a function to determine if it is possible to travel from every open cell on the board to the given end position.

board1 = [
    [ 0,  0,  0, 0, -1 ],
    [ 0, -1, -1, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
    [ 0, -1,  0, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
    [ 0,  0,  0, 0,  0 ],
]

board2 = [
    [  0,  0,  0, 0, -1 ],
    [  0, -1, -1, 0,  0 ],
    [  0,  0,  0, 0,  0 ],
    [ -1, -1,  0, 0,  0 ],
    [  0, -1,  0, 0,  0 ],
    [  0, -1,  0, 0,  0 ],
]

board3 = [
    [ 0,  0,  0,  0,  0,  0, 0 ],
    [ 0, -1, -1, -1, -1, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1,  0,  0,  0, -1, 0 ],
    [ 0, -1, -1, -1, -1, -1, 0 ],
    [ 0,  0,  0,  0,  0,  0, 0 ],
]

board4 = [
    [0,  0,  0,  0, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0,  0,  0,  0, 0],
]

board5 = [
    [0],
]

end1 = (0, 0)
end2 = (5, 0)

Expected output:

isReachable(board1, end1) -> True
isReachable(board1, end2) -> True
isReachable(board2, end1) -> False
isReachable(board2, end2) -> False
isReachable(board3, end1) -> False
isReachable(board4, end1) -> True
isReachable(board5, end1) -> True


n: width of the input board
m: height of the input board

*/

    // Method 1
    // below dfs algo is from source to destination
    // time complexity: O((n*m)(n*m)) = O(n^4)
    private static boolean dfs(int[][] board, int[] src, int[] dest, boolean[][] visited){
        if(src[0] < 0 || src[0] >= board.length || src[1] < 0 || src[1] >= board[0].length
                || board[src[0]][src[1]] == -1 || visited[src[0]][src[1]])
            return false;
        if(src[0] == dest[0] && src[1] == dest[1])
            return true;
        visited[src[0]][src[1]] = true;
        return dfs(board, new int[]{src[0]+1, src[1]}, dest ,visited)
                || dfs(board, new int[]{src[0]-1, src[1]}, dest, visited)
                || dfs(board, new int[]{src[0], src[1]+1}, dest, visited)
                || dfs(board, new int[]{src[0], src[1]-1}, dest, visited);
    }

    private static boolean isReachable(int[][] board, int[] arr){
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 0){
                    boolean[][] visited = new boolean[rows][cols];
                    if(!dfs(board, new int[]{i,j}, arr, visited)){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Method 2
    // below dfs algo is from destination to source
    // time complexity: O(n*m) = O(n^2)
    private static boolean dfs2(int[][] board, int i, int j, boolean[][] visited){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || board[i][j] == -1)
            return false;
        visited[i][j] = true;
        return dfs2(board, i+1, j, visited)
                || dfs2(board, i-1, j, visited)
                || dfs2(board, i, j+1, visited)
                ||dfs2(board, i, j-1, visited);
    }

    private static boolean isReachable2(int[][] board, int[] arr){
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++)
            Arrays.fill(visited[i], false);
        dfs2(board, arr[0], arr[1], visited);

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (board[i][j] == 0 &&  !visited[i][j])
                    return false;
            }
        }
        return true;
    }

    //Method 3
    // below bfs algo is from destination to source
    // time complexity: O(n*m) = O(n^2)
    private static void bfs(int[][] board, int row, int col, boolean[][] visited){
        int rows = board.length;
        int cols = board[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(row, col));

        while (!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int i = p.getKey();
            int j = p.getValue();
            visited[i][j] = true;

            if (i-1 >= 0 && board[i-1][j] == 0 && !visited[i-1][j]){
                q.add(new Pair<>(i-1, j));
            }
            if (i+1 < rows && board[i+1][j] == 0 && !visited[i+1][j]){
                q.add(new Pair<>(i+1, j));
            }
            if (j-1 >= 0 && board[i][j-1] == 0 && !visited[i][j-1]){
                q.add(new Pair<>(i, j-1));
            }
            if (j+1 < cols && board[i][j+1] == 0 && !visited[i][j+1]){
                q.add(new Pair<>(i, j+1));
            }
        }
    }

    private static boolean isReachable3(int[][] board, int[] arr){
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++)
            Arrays.fill(visited[i], false);
        bfs(board, arr[0], arr[1], visited);

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (board[i][j] == 0 &&  !visited[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] argv) {
        int[][] board = new int[][] {
                {0,  0,  0, -1, -1},
                {0,  0, -1,  0,  0},
                {0, -1,  0, -1,  0},
                {0,  0, -1,  0,  0},
                {0,  0,  0,  0,  0},
                {0,  0,  0,  0,  0},
                {0,  0,  0,  0,  0},
        };

        int[][] board1 = new int[][] {
                { 0,  0,  0, 0, -1 },
                { 0, -1, -1, 0,  0 },
                { 0,  0,  0, 0,  0 },
                { 0, -1,  0, 0,  0 },
                { 0,  0,  0, 0,  0 },
                { 0,  0,  0, 0,  0 },
        };

        int[][] board2 = new int[][] {
                {  0,  0,  0, 0, -1 },
                {  0, -1, -1, 0,  0 },
                {  0,  0,  0, 0,  0 },
                { -1, -1,  0, 0,  0 },
                {  0, -1,  0, 0,  0 },
                {  0, -1,  0, 0,  0 },
        };

        int[][] board3 = new int[][] {
                { 0,  0,  0,  0,  0,  0, 0 },
                { 0, -1, -1, -1, -1, -1, 0 },
                { 0, -1,  0,  0,  0, -1, 0 },
                { 0, -1,  0,  0,  0, -1, 0 },
                { 0, -1,  0,  0,  0, -1, 0 },
                { 0, -1, -1, -1, -1, -1, 0 },
                { 0,  0,  0,  0,  0,  0, 0 },
        };

        int[][] board4 = new int[][] {
                { 0,  0,  0,  0, 0 },
                { 0, -1, -1, -1, 0 },
                { 0, -1, -1, -1, 0 },
                { 0, -1, -1, -1, 0 },
                { 0,  0,  0,  0, 0 },
        };

        int[][] board5 = new int[][] {
                { 0 },
        };

        int[] end1 = new int[] {0, 0};
        int[] end2 = new int[] {5, 0};

        System.out.println(isReachable3(board1, end1));
        System.out.println(isReachable3(board1, end2));
        System.out.println(isReachable3(board2, end1));
        System.out.println(isReachable3(board2, end2));
        System.out.println(isReachable3(board3, end1));
        System.out.println(isReachable3(board4, end1));
        System.out.println(isReachable3(board5, end1));
        /*System.out.println(isReachable2(board1, end1));
        System.out.println(isReachable2(board1, end2));
        System.out.println(isReachable2(board2, end1));
        System.out.println(isReachable2(board2, end2));
        System.out.println(isReachable2(board3, end1));
        System.out.println(isReachable2(board4, end1));
        System.out.println(isReachable2(board5, end1));*/
        /*System.out.println(isReachable(board1, end1));
        System.out.println(isReachable(board1, end2));
        System.out.println(isReachable(board2, end1));
        System.out.println(isReachable(board2, end2));
        System.out.println(isReachable(board3, end1));
        System.out.println(isReachable(board4, end1));
        System.out.println(isReachable(board5, end1));*/
        /*isReachable(board1, end1) -> True
            isReachable(board1, end2) -> True
            isReachable(board2, end1) -> False
            isReachable(board2, end2) -> False
            isReachable(board3, end1) -> False
            isReachable(board4, end1) -> True
            isReachable(board5, end1) -> True
            */
    }
}
