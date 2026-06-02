import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n***** Geometrical Calculator *****\n");

        // Shapes Management
        Scanner input = new Scanner(System.in);
        System.out.println(
                "1: add a shape\n" +
                "2: remove a shape by position\n" +
                "3: get information about a shape by position\n" +
                "4: area and perimeter of a shape by position\n" +
                "5: Display information of all the shapes\n" +
                "6: translate all the shapes\n" +
                "7: scale all the shapes\n" +
                "0: quit program\n");

        int choice = input.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Have A Good Day.");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            case 7:
                System.out.println("7");
                break;
        }
    }
}
