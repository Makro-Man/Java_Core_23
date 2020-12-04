package ua.lviv.lesson13;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> menu = () -> {
            System.out.println();
            System.out.println("Введіть 1 щоб додати фракцію");
            System.out.println("Введіть 2 щоб видалити конкретну фракцію");
            System.out.println("Введіть 3 щоб вивести усі  фракції");
            System.out.println("Введіть 4 щоб очистити конкретну фракцію");
            System.out.println("Введіть 5 щоб вивести конкретну фракцію");
            System.out.println("Введіть 6 щоб додати депутата в фракцію");
            System.out.println("Введіть 7 щоб видалити депутата з фракції");
            System.out.println("Введіть 8 щоб вивести список хабарників");
            System.out.println("Введіть 9 щоб вивести найбільшого хабарника");

            Scanner scanner = new Scanner(System.in);
            int menuChoise = scanner.nextInt();

            return menuChoise;
        };

        while (true) {
            switch (menu.get()) {

                case 1: {
                    VerkhovnaRada.getInstance().addDeputyGroup();
                    break;
                }

                case 2: {
                    VerkhovnaRada.getInstance().removeDeputyGroup();
                    break;
                }

                case 3: {
                    VerkhovnaRada.getInstance().getAllDeputyGroups();
                    break;
                }

                case 4: {
                    VerkhovnaRada.getInstance().clearDeputyGroup();
                    break;
                }

                case 5: {
                    VerkhovnaRada.getInstance().getDeputyGroup();
                    break;
                }

                case 6: {
                    VerkhovnaRada.getInstance().addDeputyToDeputyGroup();
                    break;
                }

                case 7: {
                    VerkhovnaRada.getInstance().removeDeputyFromDeputyGroup();
                    break;
                }

                case 8: {
                    VerkhovnaRada.getInstance().getBribeTakersFromDeputyGroup();
                    break;
                }

                case 9: {
                    VerkhovnaRada.getInstance().getLargestBribeTakerFromDeputyGroup();
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
