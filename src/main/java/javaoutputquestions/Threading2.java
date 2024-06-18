package javaoutputquestions;

public class Threading2 implements Runnable{
    public void run(){
        System.out.println("running");
    }

    public static void main(String[] args){
        Thread t= new Thread(new Threading2());
        t.run();
        t.run();
        t.start();

        /*if you uncomment below command, you cannot start an already started thread
        * throws a runtime exception: Exception in thread "main" java.lang.IllegalThreadStateException*/
        //t.start();
    }
}
