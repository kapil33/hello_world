package javaoutputquestions;

public class ExceptionHandling {
    public static void main(String[] args){
        try {
            System.out.println("Hello World");
        }catch (Exception e){
            System.out.println("e");
        }/*below catch gives a compile error
            error: java: exception java.lang.ArithmeticException has already been caught
        */
        /*catch (ArithmeticException e){
            System.out.println("e");
        }*/finally {
            System.out.println("!");
        }
    }
}
