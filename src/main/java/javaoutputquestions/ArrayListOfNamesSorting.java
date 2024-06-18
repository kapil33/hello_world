package javaoutputquestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListOfNamesSorting {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("kapil");
        names.add("gaveesh");
        names.add("raman");

        //Ways of sorting Alphabetically
        //1st way: it works
        /*Collections.sort(names);
        System.out.println(names);*/

        //2nd way: it works
        names = names.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(names);

        //3rd way: does not work, as List.DESCENDING does not exist
        //names.sort(List.DESCENDING);

        //4th way: it works
        names.sort(Comparator.comparing(String::toString));
        System.out.println(names);
    }
}
