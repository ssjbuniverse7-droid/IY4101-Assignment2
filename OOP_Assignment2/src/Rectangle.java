public class Rectangle extends Shape {
    // Properties
    private double width;
    private double length;
    // Constructor
    public Rectangle (Coordinates coord, double side) {
        super(4, coord);
        this.length = length;
        this.width = width;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.length *= factor;
        } else {
            this.length /= factor;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * length * width;
    }

    @Override
    public double getPerimeter() {
        return (2 * length) + (2 * width);
    }

    @Override
    public String display() {
        return "Rectangle at " + position.display() + ", length: " + length;
    }
}
