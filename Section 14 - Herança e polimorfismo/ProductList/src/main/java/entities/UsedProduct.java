package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private Date manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Iphone (used) $ 400.00 (Manufacture date: 15/03/2017)
        return getName() + " (used) $" + String.format("%.2f",getPrice()) + " (Manufacture date: " + sdf.format(getManufactureDate()) + ")";
    }
}
