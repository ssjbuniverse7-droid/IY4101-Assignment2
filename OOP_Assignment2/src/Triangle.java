public class Triangle extends Shape {
    private Coordinates vertexA;
    private Coordinates vertexB;
    private Coordinates vertexC;

    // Constructor
     public Triangle (Coordinates coord, double vertexA, double vertexB, double vertexC) {
         super(3, coord);
         this.vertexA = vertexA;
         this.vertexB = vertexB;
         this.vertexC = vertexC;
     }

    @Override
    public double getArea() {
        double s = (vertexA + vertexB + vertexC) / 2;
        return Math.sqrt(s * (s - vertexA) * (s - vertexB) * (s - vertexC));
    }

    @Override
    public double getPerimeter() {
        double distAB = vertexA - vertexB;
        double distBC = vertexB - vertexC;
        double distCA = vertexC - vertexA;
        return distAB + distBC + distCA;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.vertexA *= factor;
            this.vertexB *= factor;
            this.vertexC *= factor;
        } else {
            this.vertexA /= factor;
            this.vertexB /= factor;
            this.vertexC /= factor;
        }
    }

    @Override
    public String display() {
        return "Triangle at " + position.display() + ", Vertices: " + vertexA + "," + vertexB + "," + vertexC;
    }
}
