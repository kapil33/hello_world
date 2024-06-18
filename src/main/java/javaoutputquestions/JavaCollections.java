package javaoutputquestions;

import java.util.HashSet;
import java.util.Set;

class KeyMaster{
    public int i;
    public KeyMaster(int i){this.i = i;}
    public boolean equal(Object o){return i == ((KeyMaster)o).i;}
    public int hashCode(){return i;}
}

public class JavaCollections {
    public static void main(String[] args){
        Set<KeyMaster> set = new HashSet<>();
        KeyMaster k1 = new KeyMaster(1);
        KeyMaster k2 = new KeyMaster(2);
        set.add(k1);set.add(k1);
        set.add(k2);set.add(k2);
        System.out.println(set.size() + ":");
        System.out.println(set.toString());
        k2.i = 1;
        System.out.println(set.size() + ":");
        System.out.println(set.toString());
        set.remove(k1);
        System.out.println(set.size() + ":");
        System.out.println(set.toString());
        set.remove(k2);
        System.out.println(set.size() + ":");
        System.out.println(set.toString());
    }
}
