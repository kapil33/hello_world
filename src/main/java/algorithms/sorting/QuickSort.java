package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

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
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    public void sort(int[] nums, int start, int end){
        if (start < end){
            int pivot = partition(nums, start, end);
            sort(nums, start, pivot-1);
            sort(nums, pivot+1, end);
        }
    }

    public static void main(String[] args) {
        //int[] arr = {12, 11, 13, 5, 6, 7};
        int[] arr = {12, 11, -13, -5, 6, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
