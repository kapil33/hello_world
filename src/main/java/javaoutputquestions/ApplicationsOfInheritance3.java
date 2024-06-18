package javaoutputquestions;

import java.util.stream.Stream;

public class ApplicationsOfInheritance3 {
    class Vehicle{
        public void drive(){

        }
    }

    class Scooty extends Vehicle{
        /*cannot have a restricted access modifier in overriding method*/
        /*private void drive(){

        }*/
    }

    static class MyAdd<T> {
        void add(T t){

        }
    }

    public static void main(String[] args) {
        /*Object[] objects = {new Integer(11), new String("foo"),
                new Integer(5), new boolean(true)};*/
        MyAdd<Number> myAdd = new MyAdd<>();
        myAdd.add(new Integer(1));
        myAdd.add(new Double(1.0));

        Stream.of(1,2,3,4,5,6,7,8,9,10,11)
                .skip(5)
                .forEach(num -> System.out.println(num + " "));
    }
}
