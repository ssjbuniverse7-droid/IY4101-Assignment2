import java.util.InputMismatchException;
import java.util.Scanner;

public class Shape_Management {

    private Shape_List shapes;
    private Scanner input;

    public Shape_Management() {
        shapes = new Shape_List();
        input = new Scanner(System.in);
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n--------- Main Menu ---------");
            System.out.println("1. Add Shape");
            System.out.println("2. Remove Shape");
            System.out.println("3. Get Shape Info");
            System.out.println("4. Calculate Area & Perimeter");
            System.out.println("5. Translate Shapes");
            System.out.println("6. Scale Shapes");
            System.out.println("7. Show All Shapes");
            System.out.println("0. Exit");

            System.out.print("Choice: ");

            try {
                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        addShape();
                        break;

                    case 2:
                        removeShape();
                        break;

                    case 3:
                        getShapeInfo();
                        break;

                    case 4:
                        calculateShape();
                        break;

                    case 5:
                        translateShape();
                        break;

                    case 6:
                        scaleShape();
                        break;

                    case 7:
                        showShapes();
                        break;

                    case 0:
                        System.out.println("Have a good day!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                choice = -1;
            }

        } while (choice != 0);
    }

    private void addShape() {

        System.out.print("Shape (C=Circle, S=Square, R=Rectangle, T=Triangle): ");
        char type = input.next().toUpperCase().charAt(0);

        try {
            switch (type) {
                case 'C': {
                    System.out.print("Center X: ");
                    int x = input.nextInt();

                    System.out.print("Center Y: ");
                    int y = input.nextInt();

                    System.out.print("Radius: ");
                    double radius = input.nextDouble();

                    if (radius <= 0) {
                        System.out.println("Radius must be greater than 0.");
                    } else {
                        shapes.addShape(new Circle(new Coordinates(x, y), radius));
                        System.out.println("Shape added successfully.");
                    }

                    break;
                }

                case 'S': {
                    System.out.print("X: ");
                    int x = input.nextInt();

                    System.out.print("Y: ");
                    int y = input.nextInt();

                    System.out.print("Side: ");
                    double side = input.nextDouble();

                    if (side <= 0) {
                        System.out.println("Side size must be greater than 0.");
                    } else {
                        shapes.addShape(new Square(new Coordinates(x, y), side));
                        System.out.println("Shape added successfully.");
                    }

                    break;
                }

                case 'R': {
                    System.out.print("X: ");
                    int x = input.nextInt();

                    System.out.print("Y: ");
                    int y = input.nextInt();

                    System.out.print("Length: ");
                    double length = input.nextDouble();

                    System.out.print("Width: ");
                    double width = input.nextDouble();

                    if (length <= 0 || width <=0) {
                        System.out.println("Length and width size must be greater than 0.");
                    } else {
                        shapes.addShape(new Rectangle(new Coordinates(x, y), length, width));
                        System.out.println("Shape added successfully.");
                    }

                    break;
                }

                case 'T': {
                    System.out.println("Vertex A");
                    System.out.print("X: ");
                    int ax = input.nextInt();
                    System.out.print("Y: ");
                    int ay = input.nextInt();

                    System.out.println("Vertex B");
                    System.out.print("X: ");
                    int bx = input.nextInt();
                    System.out.print("Y: ");
                    int by = input.nextInt();

                    System.out.println("Vertex C");
                    System.out.print("X: ");
                    int cx = input.nextInt();
                    System.out.print("Y: ");
                    int cy = input.nextInt();

                    double area = Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by) ) / 2.0;

                    if (area == 0) {
                        System.out.println("That doesn't form a triangle.");
                    }
                    else {
                        shapes.addShape(new Triangle(new Coordinates(ax, ay), new Coordinates(bx, by), new Coordinates(cx, cy)));
                        System.out.println("Shape added successfully.");
                    }
                    break;
                }

                default:
                    System.out.println("Unknown shape.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            input.nextLine();
        }
    }

    private void removeShape() {

        if (shapes.size() == 0) {
            System.out.println("No shapes stored.");
            return;
        }

        showShapes();

        System.out.print("Enter ID to remove: ");
        int id = input.nextInt();

        if (shapes.isValid(id)) {
            shapes.removeShape(id);
            System.out.println("Shape removed.");
        } else {
            System.out.println("Invalid ID.");
        }
    }

    private void getShapeInfo() {

        if (shapes.size() == 0) {
            System.out.println("No shapes stored.");
            return;
        }

        showShapes();

        System.out.print("Enter ID: ");
        int id = input.nextInt();

        if (shapes.isValid(id))
            System.out.println(shapes.getShape(id).display());
        else
            System.out.println("Invalid ID.");
    }

    private void calculateShape() {

        if (shapes.size() == 0) {
            System.out.println("No shapes stored.");
            return;
        }

        showShapes();

        System.out.print("Enter ID: ");
        int id = input.nextInt();

        if (shapes.isValid(id)) {

            System.out.printf("Area = %.2f%n", shapes.area(id));
            System.out.printf("Perimeter = %.2f%n", shapes.perimeter(id));

        } else {

            System.out.println("Invalid ID.");

        }
    }

    private void translateShape() {

        if (shapes.size() == 0) {
            System.out.println("No shapes stored.");
            return;
        }

        showShapes();

        System.out.println("--- Choose shapes ---\n1 - Translate by ID\n2 - Translate all shapes");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = input.nextInt();

            if (!shapes.isValid(id)) {
                System.out.println("Invalid ID.");
                return;
            }

            System.out.print("dx: ");
            int dx = input.nextInt();

            System.out.print("dy: ");
            int dy = input.nextInt();

            shapes.getShape(id).translate(dx, dy);

            System.out.println("Shape translated.");

        } else if (choice == 2) {
            System.out.print("dx: ");
            int dx = input.nextInt();

            System.out.print("dy: ");
            int dy = input.nextInt();

            shapes.translateShapes(dx,dy);

            System.out.println("All shapes translated.");

        } else {
            System.out.println("Invalid input.");
        }
    }

    private void scaleShape() {

        if (shapes.size() == 0) {
            System.out.println("No shapes stored.");
            return;
        }

        showShapes();

        System.out.println("--- Choose shapes ---\n1 - Scale by ID\n2 - Scale all shapes");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = input.nextInt();

            if (!shapes.isValid(id)) {
                System.out.println("Invalid ID.");
                return;
            }

            System.out.print("Factor: ");
            int factor = input.nextInt();

            System.out.print("true = enlarge, false = shrink: ");
            boolean sign = input.nextBoolean();

            shapes.getShape(id).scale(factor, sign);

            System.out.println("Shape scaled.");

        } else if (choice == 2) {
            System.out.print("Factor: ");
            int factor = input.nextInt();

            System.out.print("true = enlarge, false = shrink: ");
            boolean sign = input.nextBoolean();

            shapes.scale(factor,sign);

            System.out.println("All shapes scaled.");

        } else {
            System.out.println("Invalid input.");
        }
    }

    private void showShapes() {
        if (shapes.size() == 0)
            System.out.println("No shapes stored.");
        else
            System.out.println(shapes.display());
    }
}
