public class Coordinates {
    // Properties
    private int x;
    private int y;
    double p = getX() + getY();

    // Constructor
    public Coordinates(int x, int y) {
        this.x = 0;
        this.y = 0;
    }

    // Getter Methods
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Distance Calculator
    public double distance(Coordinates p1, Coordinates p2) {
        return Math.sqrt( Math.pow( 2,2 ) + Math.pow( getY() - y,2 )); // ??
    }

    // Translator
    public void translator(int dx, int dy) {
        // ??
    }

    // Scaler
    public void scaler(int factor, boolean sign) {
        if (sign) {
            System.out.println("Positive scale");
        }
        else {
            System.out.println("Negative scale");
        }
    }

    // Display
    public String display() {
        return "Final Result: ";
    }
}
