package interviews.twentytwentyfour.safesecurities;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public void addSubString(List<String> stringList, String s, int i, int j) {
        String result = "";
        for (int k=i; k<j; k++) {
            result += s.charAt(k);
        }

        stringList.add(result);
    }

    public String reverseString(String s) {
        if (s == null || s.isEmpty())
            return null;
        List<String> stringList = new ArrayList<>();
        String result = "";

        for(int i=0; i<s.length(); ) {
            if (s.charAt(i) != ' ') {
                int j=i+1;

                while (j<s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                //stringList.add(s.substring(i, j));
                addSubString(stringList, s, i, j);
                i=j;
            } else {
                i++;
            }
        }

        for (int i=stringList.size()-1; i>=0; i--) {
            //System.out.println(stringList.get(i));
            result += stringList.get(i);

            if (i > 0) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("Hello World"));
        System.out.println("\n***************\n");
        System.out.println(reverseString.reverseString("  Hello   World  "));
        System.out.println("\n***************\n");
        System.out.println(reverseString.reverseString("  I Love cricket"));
    }
}