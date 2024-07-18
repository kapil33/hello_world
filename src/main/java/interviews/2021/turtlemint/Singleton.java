package gfg.interviews.turtlemint;

public class Singleton {
    int singleVar;

    public static final Singleton instance = getInstance();
    private static Singleton getInstance(){
        return new Singleton();
    }
    private Singleton(){
        singleVar = 10;
    }
}
