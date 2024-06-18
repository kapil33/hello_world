package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public void merge(int[] nums, int start, int mid, int end){
        int n1 = mid-start+1, n2 = end-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i=0; i<n1; i++)
            left[i] = nums[start+i];
        for (int j=0; j<n2; j++)
            right[j] = nums[mid+1+j];
        int i=0, j=0, k=start;
        while (i < n1 && j < n2){
            if (left[i] < right[j])
                nums[k++] = left[i++];
            else
                nums[k++] = right[j++];
        }
        while (i < n1)
            nums[k++] = left[i++];
        while (j < n2)
            nums[k++] = right[j++];
    }

    public void mergeSort(int[] nums, int start, int end){
        if (start < end){
            int mid = start + (end-start)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
