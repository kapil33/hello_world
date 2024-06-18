package algorithms.sorting;

public class CountInversions {
    /*
    Inversion Count for an array indicates – how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in the reverse order, the inversion count is the maximum.
    Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
    Example:
    Input: arr[] = {8, 4, 2, 1}
    Output: 6
    Explanation: Given array has six inversions:
    (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
    Input: arr[] = {3, 1, 2}
    Output: 2
    Explanation: Given array has two inversions:
    (3, 1), (3, 2) */
    private int merge(int[] nums, int start, int mid, int end) {
        int n1 = mid-start+1, n2 = end-mid, swaps = 0;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i=0; i<n1; i++)
            left[i] = nums[start+i];
        for (int i=0; i<n2; i++)
            right[i] = nums[mid+i+1];
        int i=0, j=0, k=start;
        while (i < n1 && j < n2){
            if (left[i] < right[j])
                nums[k++] = left[i++];
            else {
                nums[k++] = right[j++];
                swaps += (mid - (start + i) + 1);
            }
        }
        while (i < n1)
            nums[k++] = left[i++];
        while (j < n2)
            nums[k++] = right[j++];
        return swaps;
    }

    private int mergesort(int[] nums, int start, int end){
        if (start < end){
            int mid = start + (end-start)/2;
            return mergesort(nums, start, mid)
                    + mergesort(nums, mid+1, end)
                    + merge(nums, start, mid, end);
        }
        return 0;
    }

    public static void main(String[] args) {
        CountInversions countInversion = new CountInversions();
        System.out.println(countInversion.mergesort(new int[]{8,4,2,1}, 0, 3));
        System.out.println(countInversion.mergesort(new int[]{1,2,4,8}, 0, 3));
        System.out.println(countInversion.mergesort(new int[]{3,1,2}, 0, 2));
        System.out.println(countInversion.mergesort(new int[]{1,20,6,4,5}, 0, 4));
    }
}
