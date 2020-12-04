package ua.lviv.lesson14;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> menu = () -> {
            System.out.println();
            System.out.println("Enter 1 to add a product");
            System.out.println("Enter 2 to Delete the item");
            System.out.println("Enter 3 to Replace the item");
            System.out.println("Enter 4 to Sort by name");
            System.out.println("Enter 5 to Sort by length");
            System.out.println("Enter 6 to Sort by width");
            System.out.println("Enter 7 to Sort by weight");
            System.out.println("Enter 8 to output the i-th element of the collection");
            System.out.println("Enter 9 to exit the program");

            Scanner scanner = new Scanner(System.in);
            int menuChoise = scanner.nextInt();

            return menuChoise;
        };

        Shelf shelf = new Shelf();

        while (true) {

            switch (menu.get()) {

                case 1: {
                    shelf.addCommodity();
                    break;
                }

                case 2: {
                    shelf.removeCommodity();
                    break;
                }

                case 3: {
                    shelf.replaceCommodity();
                    break;
                }

                case 4: {
                    shelf.sortByName();
                    break;
                }

                case 5: {
                    shelf.sortByLength();
                    break;
                }

                case 6: {
                    shelf.sortByWidth();
                    break;
                }

                case 7: {
                    shelf.sortByWeight();
                    break;
                }

                case 8: {
                    shelf.getCommodity();
                    break;
                }

                case 9: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Enter number 1 to 9");
                    break;
                }
            }
        }

    }
}
