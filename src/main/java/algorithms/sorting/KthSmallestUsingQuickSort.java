package algorithms.sorting;

public class KthSmallestUsingQuickSort {

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j=start; j<end; j++){
            if (nums[j] < pivot){
                swap(nums, i++, j);
            }
        }
        swap(nums, i, end);
        return i;
    }

    private int KthSmallest(int[] nums, int start, int end, int k) {
        if (k > 0 && k <= end-start+1){
            int pivot = partition(nums, start, end);

            if (pivot-start == k-1)
                return nums[pivot];
            else if (pivot-start > k-1)
                return KthSmallest(nums, start, pivot-1, k);
            else
                return KthSmallest(nums, pivot+1, end, k-(pivot-start+1));
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 5, 7, 4, 19, 26};
        KthSmallestUsingQuickSort find = new KthSmallestUsingQuickSort();
        System.out.println(find.KthSmallest(arr, 0, arr.length-1, 3));
    }
}
