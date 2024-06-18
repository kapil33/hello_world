package algorithms.dp.knapsack.bounded;

public class CountSubsetDiff {

    public static int count(int[] nums, int diff, int sum){
        int n = nums.length, s = (diff + sum)/2;
        int[][] t = new int[n+1][s+1];
        for (int j=0; j<s+1; j++)
            t[0][j] = 0;
        for (int i=0; i<n+1; i++)
            t[i][0] = 1;
        for (int i=1; i<n+1; i++){
            for(int j=1; j<s+1; j++){
                if (nums[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
            }
        }
        return t[n][s];
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1,1,2,3}, 1, 7));
    }
}
