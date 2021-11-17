package gr.athtech.athtechcrm.service;


import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto create(CustomerDto customer) {
        if (customer==null)
            return null;
        if (customer.getEmail()==null  )
            return null;
        if (customer.getEmail().equals("Italy"))
            return null;
        return new CustomerDto(customerRepository.save( customer.getCustomer()));
    }

    @Override
    public List<CustomerDto> read() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
      }

    @Override
    public CustomerDto read(long id) {
        Optional<Customer> oCustomer = customerRepository.findById(id);
        if(oCustomer.isPresent())
            return new CustomerDto(oCustomer.get());
        return null;
    }

    @Override
    public CustomerDto update(long id, CustomerDto customer) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
