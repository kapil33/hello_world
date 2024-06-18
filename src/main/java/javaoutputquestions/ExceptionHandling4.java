package javaoutputquestions;

public class ExceptionHandling4 {

    public static int test(){
        try {
            System.out.println("insise try block");
        }catch (Exception ex){
            return 100;
        }finally {
            return 200;
        }
    }

    public static void main(final String... args){
        System.out.println(test());
    }
}
