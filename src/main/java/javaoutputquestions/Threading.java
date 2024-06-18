package javaoutputquestions;

/*Notes:
* Thread class is used to start a separate thread from main thread(JVM starts a thread and calls main method).
* Thread class is quite heavy(in terms of memory), so if you want to override the run() method only then do not use Thread class, instead implement Runnable.
*
* */
class MyThread extends Thread{
    MyThread(){}
    MyThread(Runnable r){super(r);}

    /*overrides Thread class's run() method
    * Note: Read more from formal documentation
    * */
    @Override
    public void run(){
        System.out.println("Inside Thread");
        //super.run();
    }
}


/*
*Notes:
*Runnable is an interface which is implemented by Thread class or by any class that implements it.
* Read more from formal documentation
*
* */

class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Inside Runnable");
    }
}

public class Threading {
    public static void main(String[] args){
        /*Starts a new thread(separate from main thread) having a new stack of it own.
        * And executes the run() method declared in class MyThread*/
        new MyThread().start();
        /*MyRunnable's run() method overrides Thread Class's run() method
        * however, MyThread's run() method overrides everyone*/
        new MyThread(new MyRunnable()).start();

        /*MyRunnable's run() method overrides Thread Class's run() method*/
        new Thread(new MyRunnable()).start();
    }
}
