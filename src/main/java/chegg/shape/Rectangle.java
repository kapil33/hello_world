package chegg.shape;

public class Rectangle extends Shape{
    int smaller;
    int larger;

    public void print(){
        super.print();
        System.out.println("Longer side is " + larger + "\nSmaller side is " + smaller);
    }

    public int area(){
        return smaller * larger;
    }

    public int perimeter(){
        return 2*smaller + 2*larger;
    }
}
