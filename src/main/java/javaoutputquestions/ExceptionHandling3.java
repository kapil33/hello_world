package javaoutputquestions;

public class ExceptionHandling3 {
    public static void main(String[] args){
            try{
                //throw new Error();
                badMethod();
                System.out.println("inside try block");
            }catch (Exception ex){
                System.out.println("inside catch block");
            }finally {
                System.out.println("inside finally");
            }
    }
    public static void badMethod(){
        throw new Error();
    }
}
