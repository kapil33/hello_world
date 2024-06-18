package chegg;

public class PolynomialHornerRule {

    public boolean allDigits(String str){
        if (str.contains("0") && str.contains("1") && str.contains("2")
                && str.contains("3") && str.contains("4") && str.contains("5")
                && str.contains("6") && str.contains("7") && str.contains("8") && str.contains("9"))
            return true;
        return false;
    }

    public static String rightShift(String str, int number){
        StringBuilder result = new StringBuilder(str);
        int size = str.length();
        int buffer = size - number - 1;
        int index = size - 1;

        while (buffer >= 0){
            result.setCharAt(index--, result.charAt(buffer--));
        }
        number--;
        while (number >= 0){
            result.setCharAt(number--, '0');
        }

        return result.toString();
    }

    public String rPSGame(String s1, String s2){
        if((s1.equals("paper") && s2.equals("rock")) || (s1.equals("rock") && s2.equals("scissors"))
                || (s1.equals("scissors") && s2.equals("paper")))
            return "human";
        else if ((s1.equals("rock") && s2.equals("paper")) || (s1.equals("scissors") && s2.equals("rock"))
                || (s1.equals("paper") && s2.equals("scissors")))
            return "computer";
        else
            return "tie";

    }

    public static int minCents(double number){
        int integer = (int)number;
        double decimal = number-(int)number;
        if (decimal == 0)
            return 0;
        else
            return 1;
    }

    public static int evaluateIteratively(int[] poly, int x){
        int result = poly[poly.length - 1];

        for (int i = poly.length - 2; i >= 0; i--)
            result = result*x + poly[i];

        return result;
    }

    public static int evaluateRecursively(int[] poly, int index, int x, int result){
       if (index == 0)
           return result*x + poly[index];

       result = result*x + poly[index--];
       return evaluateRecursively(poly, index, x, result);
    }

    public static void main(String[] args){
        //polynomial is as follows: 2x^3 - 6x^2 + 2x -1
        int[] poly = {-1, 2, -6, 2};

        //lets evaluate this polynomial for x=3
        System.out.println(evaluateIteratively(poly, 3));

        System.out.println(evaluateRecursively(poly, 2, 3, poly[poly.length-1]));

        System.out.println(minCents(2.01));

        System.out.println(rightShift("abcdefg", 4));
    }
}
