package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.front.ApiResponse;
import gr.athtech.athtechcrm.model.Customer;

import java.util.List;

public interface CustomerService {

   String CUSTOMER_NULL =  "customer is null";
   int CUSTOMER_NULL_STATUS = 400;

    ApiResponse<CustomerDto> create(CustomerDto customer);
    ApiResponse<List<CustomerDto>> read();
    ApiResponse<CustomerDto> read(long id);
    ApiResponse<CustomerDto> update(long id, CustomerDto customer);
    ApiResponse<Boolean> delete(long id);


}
