public class Square extends Shape {
    // Properties
    private double side;

    // Constructor
    public Square (Coordinates coord, double side) {
        super(4, coord);
        this.side = side;
    }

    // Scale The Square
    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.side *= factor;
        } else {
            this.side /= factor;
        }
    }

    // Calculate Area
    @Override
    public double getArea() {
        return side * side;
    }

    // Calculate Perimeter
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    // Display Info
    @Override
    public String display() {
        return "Square at " + position.display() + ", Side size: " + side;
    }
}
