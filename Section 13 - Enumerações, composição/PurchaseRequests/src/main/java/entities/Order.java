package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.moment = new Date(System.currentTimeMillis());
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double total = 0;
        for (OrderItem item : items) {
            total += (item.subTotal());
        }
        return total;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nORDER SUMMARY: \n");
        stringBuilder.append("Order moment: ").append(sdf.format(getMoment()));
        stringBuilder.append("\nOrder status: ").append(getStatus());
        stringBuilder.append("\nClient: ").append(getClient().getName()).append(" (").append(sdf1.format(getClient().getBirthDate()));
        stringBuilder.append(") - ").append(getClient().getEmail());
        stringBuilder.append("\nOrder items:\n");
        for(OrderItem item: items){
            stringBuilder.append(item.getProduct().getName()).append(", $").append(String.format("%.2f",item.getPrice())).append(", Quantity: ");
            stringBuilder.append(item.getQuantity()).append(", Subtotal: $").append(String.format("%.2f",item.subTotal())).append("\n");
        }
        stringBuilder.append("Total price: $").append(String.format("%.2f",total()));
        return stringBuilder.toString();
    }
}
