package gr.athtech.athtechcrm.service;


import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }



    @Override
    public Customer create(Customer customer) {
        if (customer==null)
            return null;
        if (customer.getEmail()==null  )
            return null;
        if (customer.getEmail().equals("Italy"))
            return null;
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> read() {
        return customerRepository.findAll();
    }

    @Override
    public Customer read(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer update(long id, Customer customer) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
