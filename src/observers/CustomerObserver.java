package observers;

import model.Customer;

public class CustomerObserver implements Observer {
    private Customer customer;

    public CustomerObserver(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void update(String message) {
        customer.receiveNotification(message);
    }

    public String getCustomerId() {
        return customer.getUserId();
    }
}
