package leetcode;

import java.util.*;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();

        Map<Integer, List<Character>> map = new HashMap<>();
        int alpha = 97;
        for(int i=2; i<=9; i++){
            map.computeIfAbsent(i, k -> new ArrayList<>()).add((char)alpha++);
            map.computeIfAbsent(i, k -> new ArrayList<>()).add((char)alpha++);
            map.computeIfAbsent(i, k -> new ArrayList<>()).add((char)alpha++);
            /*map.put(i, new ArrayList<>());
            List<Character> l = map.get(i);
            l.add((char)alpha++);
            l.add((char)alpha++);
            l.add((char)alpha++);
            map.put(i, l);*/
            if(i == 7 || i == 9){
                /*List<Character> list = map.get(i);
                list.add((char)alpha++);
                map.put(i, list);*/
                map.computeIfAbsent(i, k -> new ArrayList<>()).add((char)alpha++);
            }
        }
        System.out.println("Map: " + map);
        List<String> result = new ArrayList<>();
        result.add("");

        for (int i=0; i<digits.length(); i++){
            List<String> subResult = new ArrayList<>();
            List<Character> mappings = map.get(digits.charAt(i)-48);

            for (int j=0; j<result.size(); j++){
                for (int k=0; k<mappings.size(); k++){
                    subResult.add(result.get(j) + mappings.get(k));
                }
            }

            result = subResult;
        }

        return result;
    }

    public static List<String> letterCombinations2(String digits) {
        Queue<String> result = new LinkedList<>();
        if (digits.isEmpty())
            return new ArrayList<>(result);
        result.add("");
        String[] mappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i=0; i<digits.length(); i++){
            String str = mappings[digits.charAt(i)-'0'];
            while (result.peek().length() == i){
                String t = result.poll();
                for (char ch: str.toCharArray())
                    result.add(t + ch);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args){
        //System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations2("23"));
    }
}
