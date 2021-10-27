package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer create(Customer customer);
    List<Customer> read();
    Customer read(int id);
    Customer update(int id, Customer customer);
    boolean delete(int id);

}
