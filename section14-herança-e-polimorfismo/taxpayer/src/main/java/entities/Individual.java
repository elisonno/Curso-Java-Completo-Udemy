package entities;

public class Individual extends Taxpayer {
    private double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if(getAnualIncome() < 20000){
            return  (getAnualIncome() * 0.15) - (getHealthExpenditures() * 0.5);
        }else {
            return (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.5);
        }

    }
}
