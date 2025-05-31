package model;

public class Supplier {
    private String supplierId;
    private String name;
    private String location;
    private String email;
    private String phone;

    public Supplier(String supplierId, String name, String location, String email, String phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
    }

    // === Getters ===

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Supplier ID: " + supplierId +
               ", Name: " + name +
               ", Location: " + location +
               ", Email: " + email +
               ", Phone: " + phone;
    }
}
