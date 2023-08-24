package entities;

public class ImportedProduct extends Product {
    private Double cutomsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double cutomsFee) {
        super(name, price);
        this.cutomsFee = cutomsFee;
    }

    public Double getCutomsFee() {
        return cutomsFee;
    }

    public void setCutomsFee(Double cutomsFee) {
        this.cutomsFee = cutomsFee;
    }

    public Double totalPrice(){
        return getPrice()+getCutomsFee();
    }

    @Override
    public String priceTag() {
        return getName() + " $" + String.format("%.2f",totalPrice()) + " (Customs fee: $" + String.format("%.2f", getCutomsFee()) + ")";
    }
}
