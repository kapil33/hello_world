package algorithms.recursion.medium;

public class OccurenceOfPi {

    /*With Recursion*/
    public static String piWithRecursion(String str){
        if (str.length() <= 1)
            return str;

        if (str.substring(0, 2).equals("pi"))
            return "3.14" + piWithRecursion(str.substring(2));

        return str.charAt(0) + piWithRecursion(str.substring(1));
    }

    /*Iterative*/
    public static String pi(String str){
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i++){
            if(i+2 <= str.length() && str.substring(i, i+2).equals("pi")){
                sb.append("3.14");
                i++;
            }
            else {
                sb.append(str.substring(i, i + 1));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println("2 * pi + 3 * pi = 5 * pi");
        System.out.println("Expected: \n" + "2 * 3.14 + 3 * 3.14 = 5 * 3.14");
        System.out.println(pi("2 * pi + 3 * pi = 5 * pi"));

        System.out.println("\npippppiiiipi");
        System.out.println("Expected: \n" + "3.14ppp3.14iii3.14");
        System.out.println(pi("pippppiiiipi"));

        System.out.println("\nxpix");
        System.out.println("Expected: \n" + "x3.14x");
        System.out.println(pi("xpix"));

        System.out.println("\n*******************************************\n");

        System.out.println("2 * pi + 3 * pi = 5 * pi");
        System.out.println("Expected: \n" + "2 * 3.14 + 3 * 3.14 = 5 * 3.14");
        System.out.println(piWithRecursion("2 * pi + 3 * pi = 5 * pi"));

        System.out.println("\npippppiiiipi");
        System.out.println("Expected: \n" + "3.14ppp3.14iii3.14");
        System.out.println(piWithRecursion("pippppiiiipi"));

        System.out.println("\nxpix");
        System.out.println("Expected: \n" + "x3.14x");
        System.out.println(piWithRecursion("xpix"));
    }
}
