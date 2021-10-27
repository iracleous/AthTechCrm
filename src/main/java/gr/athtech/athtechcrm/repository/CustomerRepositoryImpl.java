package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> read() {
        return null;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public Customer update(int id, Customer customer) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
