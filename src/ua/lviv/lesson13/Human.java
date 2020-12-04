package ua.lviv.lesson13;

public class Human {
    private double weight;
    private double growth;

    public Human() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public Human(double weight, double growth) {
        this.weight = weight;
        this.growth = growth;
    }

    @Override
    public String toString() {
        return "Human{" +
                "weight=" + weight +
                ", growth=" + growth +
                '}';
    }
}
