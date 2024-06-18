package algorithms.recursion.medium;

public class StringToInteger {

    public static int convert(String str){
        if (str.length() == 1)
            return Character.getNumericValue(str.charAt(0));

        double y = convert(str.substring(1));
        double x = Character.getNumericValue(str.charAt(0));

        x = x * Math.pow(10, str.length()-1) + y;

       return (int)x;
    }

    public static int iterate(String str){
        int result = 0;

        for (int i=0; i<str.length(); i++){
            result = result*10 + Character.getNumericValue(str.charAt(i));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(convert("0000145"));
        System.out.println(convert("1234"));

        System.out.println("\n**********************************\n");

        System.out.println(iterate("0000145"));
        System.out.println(iterate("1234"));
    }
}
