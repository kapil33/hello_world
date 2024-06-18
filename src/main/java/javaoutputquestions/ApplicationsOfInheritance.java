package javaoutputquestions;

public class ApplicationsOfInheritance {

    Object message(){
        return "Hello!";
    }

    public static void main(String[] args){
        System.out.print(new ApplicationsOfInheritance().message());

        /*
        * Below line of code gives compile error if ApplicationsOfInheritance2 is not static:
        *
        * error: java: non-static variable this cannot be referenced from a static context
        *
        * */
        //System.out.print(new ApplicationsOfInheritance2().message());
    }

    class ApplicationsOfInheritance2 extends ApplicationsOfInheritance{
        String message(){
            return "World!";
        }
    }
}
