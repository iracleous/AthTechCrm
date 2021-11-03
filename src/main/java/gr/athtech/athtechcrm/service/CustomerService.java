package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> read();
    Customer read(long id);
    Customer update(long id, Customer customer);
    boolean delete(long id);


}
