package algorithms.recursion.easy;

public class Factorial {

    public static int fact(int nums){
        if(nums == 1)
            return 1;

        return nums * fact(nums-1);
    }

    public static void main(String[] main){
        System.out.println(fact(4));
    }
}
