package interviews.flipkart;

public class DivisibleByThree {
    /*Problem Statement: given an integer string, you can change one integer at an index to values [0,9] keeping other indices same.
    * Count the number of unique integers that can be produced which are divisible by 3
    *
    * For Example: String  = "24"
        Possible combinations = 24, 21, 27, 54, 84
        Answers = 5
    * */

    public static int count(String str){
        int sum = 0, count = 0;
        for (int i=0; i<str.length(); i++){
            sum += (int)str.charAt(i) - '0';
        }
        if(sum % 3 == 0)
            count++;

        for (int i=0; i<str.length(); i++){
            int num = (int)str.charAt(i) - '0';
            sum -= num;
            for (int j=0; j<=9; j++){
                if (num != j && (sum + j)%3 == 0)
                    count++;
            }
            sum += num;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("24"));
        System.out.println(count("11"));
        System.out.println(count("111"));
    }
}
