package javaoutputquestions;

import java.util.HashSet;

public class JavaCollections2 {
    private String s;

    public JavaCollections2(String s){this.s = s;}

    public static void main(String[] args){
        HashSet<Object> hs = new HashSet<>();
        JavaCollections2 jv1 = new JavaCollections2("aardvark");
        JavaCollections2 jv2 = new JavaCollections2("aardvark");
        String s1 = new String("aardvark");
        String s2 = new String("aardvark");
        hs.add(jv1);
        hs.add(jv2);
        hs.add(s1);
        hs.add(s2);
        System.out.println(hs.size());
    }
}
