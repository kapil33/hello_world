package javaoutputquestions;

public class StringApplication2 {
    public static void main(String[] args){
        String message = "Hello world!";
        /*
        * Below statement throws a Runtime Exception
        *
        * error: index out of bound
        *
        * */
        String newMessage = message.substring(6, 12) + message.substring(12, 6);
        System.out.println(newMessage);
    }
}
