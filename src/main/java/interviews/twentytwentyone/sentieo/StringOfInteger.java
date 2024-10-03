package interviews.twentytwentyone.sentieo;

public class StringOfInteger {
    /*Problem Statement: given a string of integers and index, in which all integers are present in ascending order.

    For Example: String str = "1234567891011121314151617181920"

    Explanation:
    first 9 index of string represent integers from 1 to 9
    then integers present are 10, 11, 12....so on and so forth
    * */

    public static int getLengthOfInteger(int index){
        int range = 9, curr = 0, numberOfDigits = 1;

        while (curr < index){
            curr += range*Math.pow(10, numberOfDigits-1)*numberOfDigits;
            numberOfDigits++;
        }

        return numberOfDigits-1;
    }

    public static void main(String[] args) {
        System.out.println(getLengthOfInteger(5));
        System.out.println(getLengthOfInteger(100));
        System.out.println(getLengthOfInteger(189));
        System.out.println(getLengthOfInteger(190));
        System.out.println(getLengthOfInteger(2889));
        System.out.println(getLengthOfInteger(2890));
    }
}
