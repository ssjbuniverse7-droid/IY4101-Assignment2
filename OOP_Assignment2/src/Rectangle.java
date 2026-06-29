public class Rectangle extends Shape {
    // Properties
    private double length;
    private double width;

    // Constructor
    public Rectangle(Coordinates coord, double length, double width) {
        super(4, coord);
        this.length = length;
        this.width = width;
    }

    // Scale The Rectangle
    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            length *= factor;
            width *= factor;
        } else {
            length /= factor;
            width /= factor;
        }
    }

    // Calculate Area
    @Override
    public double getArea() {
        return length * width;
    }

    // Calculate Perimeter
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Display Info
    @Override
    public String display() {
        return "Rectangle at " + position.display() + ", Length: " + length + ", Width: " + width;
    }
}
