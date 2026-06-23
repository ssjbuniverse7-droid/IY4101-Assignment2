public class Coordinates {
    // Properties
    private int x;
    private int y;

    // Constructor
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter Methods
    public int getX() {
        return this.x;
    }
    public int getY() {
        return y;
    }

    // Distance Calculator
    public double distance(Coordinates p) {
        int distX = this.x - p.getX();
        int distY = this.y - p.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    // Translator
    public void translator(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Scaler
    public void scaler(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        }
        else {
            this.x /= factor;
            this.y /= factor;
        }
    }

    // Display
    public String display() {
        String msg = "X = " + x + ", Y = " + y;
        if (x < 0 || y < 0) {
            msg += "\nNote: Negative X or Y, Coordinates are out of zone.\n";
        }
        return msg;
    }
}
