/*
package guice;

public interface Shape {
    public void createShape();
    public int getParams();
}

public class ShapeClient {
    public ShapeClient(ClientMode mode){
        //PRIVILEGED, NON_PRIVILEGED
    }
}

public class Square implements Shape {
    ShapeClient shapeClient;

    //caches

    @Override
    public void createShape(){

    }

    @Override
    public int getParams(){

    }
}


class Module(){
    void configure(){
        bind(ShapeClinet).annotatedwith("PRIVILEGED").to(ShapeClient("PRIVILEGED"));
        bind(ShapeClinet).annotatedwith("NON_PRIVILEGED").to(ShapeClient("NON_PRIVILEGED"));
    }

    @Provides
    @Named("PRIVILEGED")
    public Shape getPrivilegedShape(@Named("PRIVILEGED") ShapeClient shapeClient){
        return new Square(shapeClient);
    }

    @Provides
    @Named("NON_PRIVILEGED")
    public Shape getNonPrivilegedShape(@Named("NON_PRIVILEGED") ShapeClient shapeClient){
        return new Square(shapeClient);
    }
}

public class LearnGuice {
    @Named("NON_PRIVILEGED") @Inject Shape shape;
}

public class LearnScala {
    @Named("NON_PRIVILEGED") @Inject Shape shape;
}

public class LearnJava {
    @Named("NON_PRIVILEGED") @Inject Shape shape;
    @Named("PRIVILEGED") @Inject Shape shape2;
}

//use MapBinder
*/
