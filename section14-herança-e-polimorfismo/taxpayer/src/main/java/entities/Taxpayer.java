package entities;

public abstract class Taxpayer {
    private String Name;
    private Double anualIncome;

    public Taxpayer() {
    }

    public Taxpayer(String name, Double anualIncome) {
        Name = name;
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public void setAnualIncome(Double anualIncome) {
        this.anualIncome = anualIncome;
    }

    public abstract Double tax();
}
