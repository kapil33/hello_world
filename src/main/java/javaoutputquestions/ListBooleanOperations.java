package javaoutputquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListBooleanOperations {
    public static void main(String[] args){
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        /*System.out.print(list.size());
        System.out.print(Arrays.toString(list.toArray()));*/

        /*
        The java instanceof operator is used to test whether the object is an
        instance of the specified type (class or subclass or interface).
        The instanceof in java is also known as type comparison operator because it compares
        the instance with type. It returns either true or false. If we apply the instanceof
        operator with any variable that has null value, it returns false.
        * */
        System.out.print(list.get(1) instanceof Boolean);
    }
}
