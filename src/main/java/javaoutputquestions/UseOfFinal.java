package javaoutputquestions;

class Base {
    /*
    * Final methods never take part in inheritance which implies
    * Final methods cant be overriden, otherwise it will give "Compilation Error"
    * */
    final public void show(){
        System.out.println("Inside base class");
    }
}

class Derived extends Base{
    /*public void show(){
        System.out.println("Inside Derived class");
    }*/
}

public class UseOfFinal{
    public static void main(String[] main){
        Base b = new Derived();
        b.show();
    }
}