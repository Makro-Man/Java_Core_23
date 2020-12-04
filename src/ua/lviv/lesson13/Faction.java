package ua.lviv.lesson13;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {
    private String nameFaction;

    public String getNameFaction() {
        return nameFaction;
    }

    public void setNameFaction(String nameFaction) {
        this.nameFaction = nameFaction;
    }

    public Faction(String nameFaction) {
        this.nameFaction = nameFaction;
    }
    List<Deputy> deputies = new ArrayList<Deputy>();
    Supplier<Deputy> createDeputy = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter firstName:");
        String firstName = scanner.next();
        System.out.println("Enter lastname:");
        String lastname = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Enter height: ");
        double growth = scanner.nextDouble();
        System.out.println("Is Grafter? ");
        boolean isGrafter = scanner.nextBoolean();

        return new Deputy(weight, growth, lastname, firstName, age, isGrafter);
    };
    Supplier<Deputy> getDeputy = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lastName:");
        String lastName = scanner.next();
        System.out.println("Enter FirstName:");
        String firstName = scanner.next();

        return new Deputy(lastName, firstName);
    };

    public void addDeputy() {
        Deputy deputy = createDeputy.get();

        if (deputy.isGrafter()) {
            deputy.getBribe();
        }

        deputies.add(deputy);
        System.out.println("Deputy " + deputy.toString() + " успішно добавлено до фракції!");
    }

    public void removeDeputy() {
        Deputy DeputyTyped = getDeputy.get();

        Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getLastName().equalsIgnoreCase(DeputyTyped.getLastName())
                && deputy.getFirstName().equalsIgnoreCase(DeputyTyped.getFirstName());
        Optional<Deputy> deputyFound = deputies.stream().filter(isEqualSurnameName).findFirst();

        if (deputyFound.isPresent()) {
            deputies.remove(deputyFound.get());
            System.out.println("Депутат " + deputyFound.toString() + " успішно видалений із фракції!");

        } else {
            System.out.println("Такого депутата немає");
        }
    }

    public void getBribeTakers() {
        System.out.println("Депутат який бере взятки:");
        List<Deputy> bribeTakers = deputies.stream().filter(Deputy::isGrafter).collect(Collectors.toList());
        bribeTakers.forEach(System.out::println);
    }

    public void getLargestBribeTaker() {
        Comparator<Deputy> deputyBribeSizeComparator = (deputy1,
                                                        deputy2) -> (deputy1.getSizeBribe() > deputy2.getSizeBribe()) ? 1
                : (deputy1.getSizeBribe() == deputy2.getSizeBribe()) ? 0 : -1;
        Optional<Deputy> largestBribeTaker = deputies.stream().filter(Deputy::isGrafter)
                .max(deputyBribeSizeComparator);

        if (largestBribeTaker.isPresent()) {
            System.out.println("Найбільший хабарник " + largestBribeTaker.get().toString());
        } else {
            System.out.println("Такого депутата немає");
        }
    }

    public void getAllDeputies() {
        System.out.println("Депутати:");
        deputies.forEach(System.out::println);
    }

    public void clearDeputyGroup() {
        deputies.clear();
        System.out.println("Депутати були видалені");
    }

    @Override
    public String toString() {
        return "Фракция \"" + deputies + "\"";
    }
}
