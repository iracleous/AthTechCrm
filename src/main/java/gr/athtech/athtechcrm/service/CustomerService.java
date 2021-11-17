package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.model.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDto create(CustomerDto customer);
    List<CustomerDto> read();
    CustomerDto read(long id);
    CustomerDto update(long id, CustomerDto customer);
    boolean delete(long id);


}
