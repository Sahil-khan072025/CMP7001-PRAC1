package model;

public class SparePart {
    private String partId;
    private String name;
    private String supplierId;
    private double price;
    private int quantity;

    public SparePart(String partId, String name, String supplierId, double price, int quantity) {
        this.partId = partId;
        this.name = name;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPartId() {
        return partId;
    }

    public String getName() {
        return name;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Part ID: " + partId + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
