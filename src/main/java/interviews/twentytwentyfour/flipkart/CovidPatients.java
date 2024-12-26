package interviews.twentytwentyfour.flipkart;

public class CovidPatients {
    /*
    Question 2:
    Covid patients are arriving in a COVID vaccination center. There are K covid patients to arrive.
    The vaccination center has N seats available with their location (location x means that the seat is
    located at a distance of x from 0). All patients should get seated. In order to maintain maximum safe distance
    between patients we want to maximize the minimum distance.
    Find this maximum of minimum distances between patients.

        Input Details:
        N K
        [List: N seat positions]

        Example Input:
        5 3
        1 2 4 8 9

        [1, ,  2, , 3]
        Ans: 3

        My Explanation:

        Search space: [1, 8]
        Mid = 4

        [1,4]
        Mid = 2

        [2,4]
        Mid = 3

        Solution:

        [1,4]
        Mid = 2

        [3,4]
        Mid = 3


TC: O(n + log(end-start) * (n)) ~ O(nlog(end-start))

[1, 8]
Mid = 4

[1,3]
Mid = 2

[2,3]
Mid = 2
*/

    private boolean isFeasible(int n, int k, int[] nums, int minDistance) {
        int lastLocation = 0, patientsCount = 1;

        for(int i=1; i<n; i++) {
            if(nums[i] - nums[lastLocation] >= minDistance) {
                patientsCount++;
                lastLocation = i;
            }
        }

        return patientsCount >= k;
    }

    public int getMaximizedMinDistance(int n, int k, int[] nums) {
        int start = Integer.MAX_VALUE, end = nums[n-1] - nums[0];

        if (n < k) // edge case
            return -1;

        for(int i=1; i<n; i++) {
            start = Math.min(start, nums[i]-nums[i-1]);
        }

        if (n == k)
            return start;

        while(start < end) {
            int mid = start + (end-start+1)/2;

            if(isFeasible(n, k, nums, mid))
                start = mid;
            else
                end = mid-1;
        }

        return start;
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] nums = new int[]{1, 2, 4, 8, 9};

        CovidPatients cp = new CovidPatients();
        System.out.println(cp.getMaximizedMinDistance(n, k, nums));
    }
}
