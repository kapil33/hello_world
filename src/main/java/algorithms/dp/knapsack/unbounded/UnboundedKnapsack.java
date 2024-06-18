package algorithms.dp.knapsack.unbounded;

public class UnboundedKnapsack {

    //top down approach
    public static int maximizeWithTopDown(int[] weight, int[] value, int n, int w){
        int[][] t = new int[n+1][w+1];
        //initialization
        for (int i=0; i<n+1; i++){
            for (int j=0; j<w+1; j++){
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if(weight[i-1] <= j)
                    t[i][j] = Math.max(
                            value[i-1] + t[i][j-weight[i-1]],
                            t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][w];
    }

    //recursive
    public static int maximize(int[] weight, int[] value, int n, int w) {
        if (n == 0 || w == 0)
            return 0;
        if (weight[n-1] <= w)
            return Math.max(
                    value[n-1] + maximize(weight, value, n, w-weight[n-1]),
                    maximize(weight, value, n-1, w));
        return maximize(weight, value, n-1, w);
    }

    public static void main(String[] args) {
        System.out.println(maximize(new int[]{1,50}, new int[]{1,30}, 2, 100));
        System.out.println(maximizeWithTopDown(new int[]{1,50}, new int[]{1,30}, 2, 100));
    }
}
