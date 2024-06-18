package javaoutputquestions;

public class UseOfStaticKeyword {
    static int count  = 0;

    public static void main(String[] args){
        //System.out.println("args: " + args);
        if (count < 3){
            //System.out.println("count: " + count);
            count++;
            main(null);
        }else {
            return;
        }

        System.out.println("Hello World!");
    }
}
