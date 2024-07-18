package gfg.interviews.morganstanley;

import java.util.*;

public class Permutations {
    /*Problem Statement:

    // Input:

// {
//  “MORGAN”,
//  “STANLEY”,
//  “INVESTMENT”,
//  “BANK”
// }

// Output:

// MSIB, MSIA, MSIN, MSIK, MSNB, ........, NYTK

// (a) What are the next two items in the output sequence..
// MSNA, MSNN


// What is the last string produced?
// NYTK
*/

    /*brute force
    * does not work with dynamic list length
    * */
    public static List<String> perm(List<String> list){
        List<String> result = new ArrayList<>();

        for(int i=0; i<list.get(0).length(); i++){
            for(int j=0; j<list.get(1).length(); j++){
                for(int k=0; k<list.get(2).length(); k++){
                    for(int z=0; z<list.get(3).length(); z++){
                        result.add("" + list.get(0).charAt(i) + list.get(1).charAt(j) + list.get(2).charAt(k) + list.get(3).charAt(z));
                    }
                }
            }
        }

        return result;
    }


    /*works with dynamic list length
    * inspired from question: letters combination
    * */
    public static List<String> perm2(List<String> list, String digits){
        String[] mappings = new String[list.size()];
        Queue<String> result = new LinkedList<>();

        int i = 0;
        for(String str: list){
            mappings[i++] = str;
        }
        //System.out.println(Arrays.toString(mappings));

        result.add("");
        for (i=0; i<digits.length(); i++){
            String str = mappings[digits.charAt(i) - '0'];

            while (result.peek().length() == i){
                String s = result.poll();
                for (int j=0; j<str.length(); j++){
                    result.add(s + str.charAt(j));
                }
            }
        }

        return new ArrayList<>(result);
    }

    /*a more succinct version of above approach*/
    public static List<String> perm3(List<String> list){
        Queue<String> result = new LinkedList<>();
        result.add("");

        for (int i=0; i<list.size(); i++){
            String str = list.get(i);

            while (result.peek().length() == i){
                String s = result.poll();
                for (int j=0; j<str.length(); j++){
                    result.add(s + str.charAt(j));
                }
            }
        }

        return new ArrayList(result);
    }



    public static void main(String[] args){
        List<String> result = new ArrayList<>();
        //result = perm(Arrays.asList("abc", "def", "gh", "i"));
        //result = perm2(Arrays.asList("abc", "def", "gh", "i"), "0123");
        result = perm3(Arrays.asList("abc", "def", "gh"));
        System.out.println(result);
        System.out.println(result.size());
    }

}
