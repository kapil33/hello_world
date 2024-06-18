package chegg.shape;

public class Eclipse extends Shape {
    int greatestRadius;
    int smallerRadius;

    public void print(){
        super.print();
        System.out.println("Bigger radius is " + greatestRadius + "\nSmaller raduis is " + smallerRadius);
    }

    public double area(){
        return 3.14*greatestRadius*smallerRadius;
    }
}
