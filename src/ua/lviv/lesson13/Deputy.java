package ua.lviv.lesson13;

import java.util.Scanner;

public class Deputy extends Human{
    private String LastName;
    private String FirstName;
    private int age;
    private boolean isGrafter;
    private int sizeBribe;

    public Deputy( String lastName, String firstName) {
        LastName = lastName;
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGrafter() {
        return isGrafter;
    }

    public void setGrafter(boolean grafter) {
        isGrafter = grafter;
    }

    public int getSizeBribe() {
        return sizeBribe;
    }

    public void setSizeBribe(int sizeBribe) {
        this.sizeBribe = sizeBribe;
    }

    public Deputy(double weight, double growth, String lastName, String firstName, int age, boolean isGrafter) {
        super(weight, growth);
        LastName = lastName;
        FirstName = firstName;
        this.age = age;
        this.isGrafter = isGrafter;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", age=" + age +
                ", isGrafter=" + isGrafter +
                ", sizeBribe=" + sizeBribe +
                ", weight=" + getWeight() +
                ", height=" + getGrowth() +
                '}';
    }
    public void getBribe(){
        if (isGrafter == false){
            System.out.println("Цей депутат не бере хабарів");
        }else if (isGrafter == true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the summ of bribe: ");
            int coutBribe = scanner.nextInt();
            if (coutBribe>5000){
                System.out.println("Поліція ув\"язнить депутата");
            }else {
                this.sizeBribe = coutBribe;
            }
        }
    }
}
