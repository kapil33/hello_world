package chegg;

public class polynomialEvaluation {

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

    }
}
