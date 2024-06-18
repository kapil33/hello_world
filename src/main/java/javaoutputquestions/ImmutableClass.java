package javaoutputquestions;

import java.util.*;

final class Student{
    private final String name;
    private final int rollNo;
    private final Map<String, String> metaData;

    /*below is called deep copying, where you make a separate data structure and enter values into it*/
    public Student(String name, int rollNo, Map<String, String> metaData){
        this.name = name;
        this.rollNo = rollNo;
        Map<String, String> temp = new HashMap<>();
        for(Map.Entry<String, String> entry: metaData.entrySet()){
            temp.put(entry.getKey(), entry.getValue());
        }
        this.metaData = temp;
    }

    /*below is called shallow copying, never do it if you want to make your class immutable*/
    /*public Student(String name, int rollNo, Map<String, String> metaData){
        this.name = name;
        this.rollNo = rollNo;
        this.metaData = metaData;
    }*/

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public Map<String, String> getMetaData() {
        Map<String, String> temp = new HashMap<>();
        for(Map.Entry<String, String> entry: metaData.entrySet()){
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }

    /*below is called shallow copying, never do it if you want to make your class immutable*/
    /*public Map<String, String> getMetaData() {
        return metaData;
    }*/
}

public class ImmutableClass {
    public static void main(String[] args){
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Maths", "100");
        metaData.put("English", "100");
        Student student = new Student("kapil", 3, metaData);
        System.out.println(student.getName());
        System.out.println(student.getRollNo());
        System.out.println(student.getMetaData());

        metaData.put("Science", "40");
        System.out.println(student.getMetaData());

        student.getMetaData().put("Physics", "90");
        System.out.println(student.getMetaData());
    }
}
