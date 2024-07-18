package gfg.interviews.morganstanley;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolObject {
    /*
    Design a custom object pool

    Specifications:
    •       There are fixed number of objects already created at startup.
    •       Object can be as simple as containing an integer.
    •       Assign any free object from the pool to incoming request.
    •       Release object and add it back to pool  when request is completed.
    APIs:
    Object getObject(Request r)
    releaseObject(Object id)
    */

    Queue<Integer> freeObjectPool;

    public ThreadPoolObject(int sizeOfPool) {
        freeObjectPool = new LinkedList<>();
        for (int i=1; i<=sizeOfPool; i++){
            freeObjectPool.add(i);
        }
    }

    public int getObject(){
        if(!freeObjectPool.isEmpty()){
            System.out.println("Thread allocated is: " + freeObjectPool.peek());
            return freeObjectPool.poll();
        }
        System.out.println("no threads available in the thread pool");
        return -1;
    }

    public void releaseObject(int objectId){
        if(freeObjectPool.size() < 5 && !freeObjectPool.contains(objectId)) {
            System.out.println("Released thread with id: " + objectId);
            freeObjectPool.add(objectId);
            return;
        }
        System.out.println("Thread is already available, nothing to release!!");
    }

    public static void main(String[] args) {
        ThreadPoolObject threadPoolObject = new ThreadPoolObject(5);
        threadPoolObject.getObject();
        threadPoolObject.getObject();
        threadPoolObject.releaseObject(1);
        threadPoolObject.releaseObject(3);
        threadPoolObject.getObject();
        System.out.println(threadPoolObject.freeObjectPool);
    }
}
