package interviews.twentytwentyfour.alphasense;

import java.util.HashMap;
import java.util.Map;

public class SmithNumber {
    /*Given a number n, the task is to find out whether this number is smith or not.
    A Smith Number is a composite number whose sum of digits is equal to the sum of digits in its prime factorization.

    Input  : n = 4
    Output : Yes
    Prime factorization = 2, 2  and 2 + 2 = 4
    Therefore, 4 is a smith number

    Input  : n = 6
    Output : No
    Prime factorization = 2, 3  and 2 + 3 is
    not 6. Therefore, 6 is not a smith number

    Input   : n = 666
    Output  : Yes
    Prime factorization = 2, 3, 3, 37 and
    2 + 3 + 3 + (3 + 7) = 6 + 6 + 6 = 18
    Therefore, 666 is a smith number

    Input   : n = 13
    Output  : No
    Prime factorization = 13 and 13 = 13,
    But 13 is not a smith number as it is not
    a composite number
     */

    public static boolean isPrime(int num) {
        for (int i=2; i<=num/2; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static boolean isSmithNumber(int num) {
        int n=num, sumOfDigits=0, sumOfPrimeFactors=0;
        Map<Integer, Integer> map = new HashMap<>();

        while(n != 0) {
            sumOfDigits += n%10;
            n /= 10;
        }

        n=num;
        for (int i=2; i<=n; ) {
            if (isPrime(i) && n%i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            } else {
                i++;
            }
        }

        for (int key: map.keySet()) {
            if (key/10 > 0) {
                int m=key, sum=0;
                while (m!=0) {
                    sum += m%10;
                    m /= 10;
                }
                sumOfPrimeFactors += sum * map.get(key);
            } else {
                sumOfPrimeFactors += key * map.get(key);
            }
            System.out.println(key + "x" + map.get(key));
        }

        return sumOfDigits == sumOfPrimeFactors && !isPrime(num);
    }

    public static void main(String[] args) {
        System.out.println("4 is a smith number: " + isSmithNumber(4));
        System.out.println("6 is a smith number: " + isSmithNumber(6));
        System.out.println("666 is a smith number: " + isSmithNumber(666));
        System.out.println("13 is a smith number: " + isSmithNumber(13));
    }
}