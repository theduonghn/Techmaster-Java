package controller;

import model.Customer;
import service.CustomerService;

import java.util.ArrayList;

public class CustomerController {
    CustomerService service = new CustomerService();
    ArrayList<Customer> customers = service.getCustomerListFromFile("customers.json");

    public void run() {
        service.showCustomers(customers);
    }
}
