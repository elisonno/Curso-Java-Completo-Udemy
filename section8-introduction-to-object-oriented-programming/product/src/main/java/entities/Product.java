package entities;

public class Product
{
    public String name;
    public double price;
    public int quantity;

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProducts(int quantity){
        if(quantity <= this.quantity) this.quantity -= quantity;
    }

// TV, $ 900.00, 10 units, Total: $ 9000.00
    public String toString() {
        return "data: " + name + ", $ " +
               String.format("%.2f" ,price) + ", " +quantity + " units" +
                ", Total: $ " + String.format("%.2f" ,totalValueInStock()) + "\n";
    }
}
