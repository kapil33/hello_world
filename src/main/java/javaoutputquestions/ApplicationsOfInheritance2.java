package javaoutputquestions;

class A{}
class B extends A{}
class C extends B{}

public class ApplicationsOfInheritance2 {
    public static void main(String[] args){
        B b = new B();
        System.out.println("b instanceof A: " + (b instanceof A));
        System.out.println("b instanceof B: " + (b instanceof B));
        System.out.println("b instanceof C: " + (b instanceof C));

        System.out.println("***************************\n");

        A a = new B(); //downcasting
        System.out.println("a instanceof A: " + (a instanceof A));
        System.out.println("a instanceof B: " + (a instanceof B));
        System.out.println("a instanceof C: " + (a instanceof C));

        System.out.println("***************************\n");

        A a1 = new C();
        System.out.println("a1 instanceof A: " + (a1 instanceof A));
        System.out.println("a1 instanceof B: " + (a1 instanceof B));
        System.out.println("a1 instanceof C: " + (a1 instanceof C));
    }
}
