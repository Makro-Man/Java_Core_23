package ua.lviv.lesson13;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class VerkhovnaRada {
    private static VerkhovnaRada instance = new VerkhovnaRada();

    private VerkhovnaRada() {
    }

    public static VerkhovnaRada getInstance() {
        if (instance == null) {
            instance = new VerkhovnaRada();
        }

        return instance;
    }

    ArrayList<Faction> supremeCouncilArray = new ArrayList<Faction>();

    Supplier<Faction> getDeputyGroup = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String deputyGroupName = scanner.next();

        return new Faction(deputyGroupName);
    };

    public Optional<Faction> findDeputyGroup() {
        Faction DeputyGroupTyped = getDeputyGroup.get();

        Predicate<Faction> isEqualDeputyGroupName = deputyGroup -> deputyGroup.getNameFaction().equalsIgnoreCase(DeputyGroupTyped.getNameFaction());
        Optional<Faction> deputyGroupFound = supremeCouncilArray.stream().filter(isEqualDeputyGroupName).findFirst();

        return deputyGroupFound;
    }

    public void addDeputyGroup() {
        Faction deputyGroup = getDeputyGroup.get();

        supremeCouncilArray.add(deputyGroup);
        System.out.println(deputyGroup.toString() + " успішно добавлено");
    }

    public void removeDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            supremeCouncilArray.remove(deputyGroupFound.get());
            System.out.println(deputyGroupFound.get().toString() + " успішно видалено");
        } else {
            System.out.println("None");
        }
    }

    public void getAllDeputyGroups() {
        System.out.println("Factions:");
        supremeCouncilArray.forEach(System.out::println);
    }

    public void clearDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().clearDeputyGroup();
        } else {
            System.out.println("None");
        }
    }

    public void getDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            System.out.println(deputyGroupFound.get().toString());
            deputyGroupFound.get().getAllDeputies();
        } else {
            System.out.println("None");
        }
    }

    public void addDeputyToDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().addDeputy();
        } else {
            System.out.println("None");
        }
    }

    public void removeDeputyFromDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().removeDeputy();
        } else {
            System.out.println("None");
        }
    }

    public void getBribeTakersFromDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().getBribeTakers();
        } else {
            System.out.println("None");
        }
    }

    public void getLargestBribeTakerFromDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().getLargestBribeTaker();
        } else {
            System.out.println("None");
        }
    }

    public void getAllDeputiesFromDeputyGroup() {
        Optional<Faction> deputyGroupFound = findDeputyGroup();

        if (deputyGroupFound.isPresent()) {
            deputyGroupFound.get().getAllDeputies();
        } else {
            System.out.println("None");
        }
    }
}

