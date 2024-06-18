package com.company;

import com.sun.corba.se.spi.orbutil.fsm.FSMTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    Integer marks;

    public Student(String name, Integer marks) {
        this.name = name;
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public Integer getMarks() {
        return marks;
    }
}

public class ComparatorFunc {
    public static void main(String[] args) {
        // write your code her
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kapil", 100));
        students.add(new Student("Garg", 90));
        students.add(new Student("Nitin", 83));
        students.add(new Student("Sharma", 99));
        students.add(new Student("Verma", 77));
        students.add(new Student("Pinku", 89));

        for (Student s: students)
            System.out.println(s.getName() + "  " + s.getMarks());

        students.sort(Comparator.comparing(Student::getMarks, (s1, s2) -> {
            return -(s1-s2);
        }));

        System.out.println("\nAfter sorting \n");

        for (Student s: students)
            System.out.println(s.getName() + "  " + s.getMarks());
    }
}
