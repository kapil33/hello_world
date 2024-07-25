package javaoutputquestions;

public class UseOfThrow {
    public static void main(String[] args){
        /**
         * Below code will print "A F D" and then throw RunTime Exception
         */
        try{
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Exception ex){ //  Both Exception & Error classes extend Throwable, hence this catch block is skipped
            System.out.println("C");
        } catch (Error error){
            System.out.println("F");
        } finally {
            System.out.println("D");
        }
    }

    public static void badMethod(){
        throw new Error();
    }
}
