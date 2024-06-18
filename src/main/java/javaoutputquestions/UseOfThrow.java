package javaoutputquestions;

public class UseOfThrow {
    public static void main(String[] args){
        /**
         * Below code will print "A D" and then throw RunTime Exception
         */
        try{
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Exception ex){
            System.out.println("C");
        }finally {
            System.out.println("D");
        }
    }

    public static void badMethod(){
        throw new Error();
    }
}
