public class Triangle extends Shape {

    // Properties
    private Coordinates vertexA;
    private Coordinates vertexB;
    private Coordinates vertexC;

    // Constructor
    public Triangle(Coordinates a, Coordinates b, Coordinates c) {
        super(3, a); // Triangle has 3 sides, position = vertexA
        this.vertexA = a;
        this.vertexB = b;
        this.vertexC = c;
    }

    // Calculate Area
    @Override
    public double getArea() {
        double area = Math.abs(vertexA.getX() * (vertexB.getY() - vertexC.getY()) +
                               vertexB.getX() * (vertexC.getY() - vertexA.getY()) +
                               vertexC.getX() * (vertexA.getY() - vertexB.getY())) /
                               2.0;

        return area;
    }

    // Calculate Perimeter
    @Override
    public double getPerimeter() {
        double sideAB = vertexA.distance(vertexB);
        double sideBC = vertexB.distance(vertexC);
        double sideCA = vertexC.distance(vertexA);

        return sideAB + sideBC + sideCA;
    }

    // Scale All Vertices
    @Override
    public void scale(int factor, boolean sign) {
        vertexA.scale(factor, sign);
        vertexB.scale(factor, sign);
        vertexC.scale(factor, sign);

        // Keep Shape.position synchronized with vertexA
        position = vertexA;
    }

    // Translate All Vertices
    @Override
    public void translate(int dx, int dy) {
        vertexA.translate(dx, dy);
        vertexB.translate(dx, dy);
        vertexC.translate(dx, dy);

        position = vertexA;
    }

    // Display Info
    @Override
    public String display() {
        String msg = "Triangle\n";
        msg += "Vertex A: " + vertexA.display() + "\n";
        msg += "Vertex B: " + vertexB.display() + "\n";
        msg += "Vertex C: " + vertexC.display() + "\n";
        msg += String.format("Area: %.2f\n", getArea());
        msg += String.format("Perimeter: %.2f", getPerimeter());

        return msg;
    }
}
