package entities;

public class Company extends Taxpayer {
    private Integer numberOfEmployee;

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployee) {
        super(name, anualIncome);
        this.numberOfEmployee = numberOfEmployee;
    }

    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public Double tax() {
        if(getNumberOfEmployee() > 10){
            return getAnualIncome() * 0.14;
        } else {
            return getAnualIncome() * 0.16;
        }

    }
}
