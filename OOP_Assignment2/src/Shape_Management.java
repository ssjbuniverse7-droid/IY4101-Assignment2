import java.util.InputMismatchException;
import java.util.Scanner;

public class Shape_Management {
    public static void main(String[] args) {
        System.out.println("\n***** Shape Management Application *****\n");

        // Shapes Management
        Scanner input = new Scanner(System.in);
        String menu = "--------------------------------------------\nMain Menu\n--------------------------------------------\n";
        menu += "1 - Add Shape\n";
        menu += "2 - Remove Shape\n";
        menu += "3 - Get Shape Info\n";
        menu += "4 - Calculate Shape Area and Perimeter\n";
        menu += "5 - Translate Shape\n";
        menu += "6 - Scale Shape\n";
        menu += "7 - Show all shapes\n";
        menu += "0 - Exit\n";
        menu += "--------------------------------------------\nEnter Your Choice: ";

        mainMenu : while (true) {
            System.out.print(menu);
            int choice = input.nextInt();

            try {
                switch (choice) {
                    case 0:
                        System.out.println("Have A Good Day.");
                        break mainMenu;

                    case 1:
                        System.out.print("Enter shape type to add: (C , T, S, R) ");
                        char type = input.next().toUpperCase().charAt(0);

                        if (type == 'C') {
                            System.out.println("New circle created.");
                        } else if (type == 'T') {
                            System.out.println("New Triangle created.");
                        } else if (type == 'S') {
                            System.out.println("New Square created.");
                        } else if (type == 'R') {
                            System.out.println("New Rectangle created.");
                        } else {
                            System.out.println("Invalid input, Try again.");
                        }
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

                    default:
                        System.out.println("Invalid input. Please choose from the menu options.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please choose from the menu options.");
                continue;
            }
        }
    }
}
