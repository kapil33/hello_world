package leetcode;

public class FirstMissingPositiveInteger {

    public int firstMissingPositiveInteger(int[] nums){
        int size = nums.length;
        int ptr = -1;

        for (int i=0; i<size; i++){
            if(nums[i] == 1){
                ptr = 1;
                break;
            }
        }

        if(ptr == -1)
            return 1;

        for (int i=0; i<size; i++){
            if (nums[i]<=0 || nums[i]>size)
                nums[i] = 1;
        }

        for (int i=0; i<size; i++)
            nums[(nums[i]-1)%size] += size;

        for (int i=0; i<size; i++){
            if (nums[i] <= size)
                return i+1;
        }

        return size+1;
    }

    public static void main(String[] args){
        FirstMissingPositiveInteger obj = new FirstMissingPositiveInteger();
        int[] arr = {1,2,3,4/*7, 8, 9, 11, 12*/};

        System.out.println("Result: " + obj.firstMissingPositiveInteger(arr));
    }
}
