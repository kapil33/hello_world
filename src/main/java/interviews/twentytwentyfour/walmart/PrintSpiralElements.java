package interviews.twentytwentyfour.walmart;

public class PrintSpiralElements {
    /*
    * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

    Input: n = 3
    Output: [[1,2,3],[8,9,4],[7,6,5]]

    input n=4
    [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
    *
    * n=3: 3R-> 2D-> 2L-> 1U-> 1R
    * n=4: 4R-> 3D-> 3L-> 2U-> 2R-> 1D-> 1L
    * n=5: 5R-> 4D-> 4L-> 3U-> 3R-> 2D-> 2L-> 1U-> 1R
    *
    * Directions: R->D->L->U->R
    *
    * R-> need row
    * D-> need col
    * L-> need row
    * U-> need col
    *
    *R[i=0, j=0], n=5,
    *
    * Algo:
    * 1. start from (0, 0) and direction=R, fill till the end or till cells are zero. For next ops pass (i+1, n-1)=(1, 4)
    * 2. start from (1, 4) and direction=D, fill till the end or till cells are zero. For next ops pass (i, j-1)=(4, 3)
    * 3. start from(4, 3) and direction=L, fill till the end or till cells are zero. For next ops pass (i-1, j)=(3, 0)
    * 4. start from(3, 0) and direction=U, fill till the end or till cells are zero. For next ops pass (i, j+1)=(1, 1)
    *
    * */

    public void print(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    public void printMatrix(int n) {
        int[][] grid = new int[n][n];
        int i=0, j=0;
        int num = 1;
        int[] dir = new int[]{0, 1, 2, 3};
        int k = 0;

        while(num <= n*n) {
            if (dir[k%4] == 0) {
                int z=j;
                for (; z<n; z++) {
                    if(grid[i][z] != 0)
                        break;
                    grid[i][z] = num++;
                }
                i++;
                j=z-1;
            } else if (dir[k%4] == 1) {
                int z=i;
                for (; z<n; z++) {
                    if (grid[z][j] != 0)
                        break;
                    grid[z][j] = num++;
                }
                i=z-1;
                j--;
            } else if (dir[k%4] == 2) {
                int z=j;
                for (; z>=0; z--) {
                    if (grid[i][z] != 0)
                        break;
                    grid[i][z] = num++;
                }
                j=z+1;
                i--;
            } else if (dir[k%4] == 3) {
                int z=i;
                for (; z>=0; z--) {
                    if (grid[z][j] != 0)
                        break;
                    grid[z][j] = num++;
                }
                i=z+1;
                j++;
            }

            k++;
        }

        print(grid);
    }

    public static void main(String[] args) {
        PrintSpiralElements wm = new PrintSpiralElements();
        wm.printMatrix(5);
        wm.printMatrix(4);
        wm.printMatrix(3);
    }
}
