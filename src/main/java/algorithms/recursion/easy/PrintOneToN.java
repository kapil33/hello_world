package algorithms.recursion.easy;

public class PrintOneToN {

    /*Prints N to 1*/
    static void print2(int nums){
        if(nums == 0)
            return;

        System.out.println(nums);
        print2(nums-1);
    }


    /*Prints 1 to N*/
    static void print(int nums){
        if(nums == 0)
            return;

        print(nums-1);
        System.out.println(nums);
    }

    public static void main(String[] args){
        print2(10);
    }
}
