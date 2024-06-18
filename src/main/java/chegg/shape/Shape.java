package chegg.shape;

class Point{
    int xAxis;
    int yAxis;
}

public class Shape {
    String colour;
    String name;
    Point coordinate;

    public void print(){
        System.out.println("Colour of the shape is " + colour + "\nName of the shape is " + name
        + "\nCoordinates are " + coordinate.xAxis + ", " + coordinate.yAxis);
    }

    public void changeColour(String name){
        this.name = name;
    }

    public void moveCenter(int xAxis, int yAxis){
        this.coordinate.xAxis = xAxis;
        this.coordinate.yAxis = yAxis;
    }
}




