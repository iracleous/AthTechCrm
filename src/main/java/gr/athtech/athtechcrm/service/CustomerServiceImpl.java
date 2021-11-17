package gr.athtech.athtechcrm.service;


import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.front.ApiResponse;
import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public ApiResponse<CustomerDto> create(CustomerDto customer) {
        log.info(String.valueOf(customer));
        ApiResponse<CustomerDto> responseCustomer;

        if (customer==null)
            responseCustomer =  new ApiResponse<CustomerDto>(CUSTOMER_NULL_STATUS,
                    CUSTOMER_NULL , null   );
        else if (customer.getEmail()==null  )
            responseCustomer =   new ApiResponse<CustomerDto>(401,
                    "no email is given", null   );
        else if (customer.getEmail().contains("@gmail"))
            responseCustomer =   new ApiResponse<CustomerDto>(402,
                    "gmail is not supported", null   );
        try{
            responseCustomer =   new ApiResponse<CustomerDto>(201,
                "ok", new CustomerDto(customerRepository.save( customer.getCustomer())));
        }
        catch(Exception e) {
            responseCustomer =   new ApiResponse<CustomerDto>(403,
                    "the customer was not saved", null   );
        }

        log.info(String.valueOf(responseCustomer));
        return responseCustomer;

    }

    @Override
    public ApiResponse<List<CustomerDto>> read() {
        return new ApiResponse<List<CustomerDto>> (200, "ok", customerRepository
                .findAll()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList()));
      }

    @Override
    public ApiResponse<CustomerDto> read(long id) {
        Optional<Customer> oCustomer = customerRepository.findById(id);
        if(oCustomer.isPresent())
            return new ApiResponse<CustomerDto>(201, "ok", new CustomerDto(oCustomer.get()));
        return new ApiResponse<CustomerDto>(400, "not found", null);
    }

    @Override
    public ApiResponse<CustomerDto>  update(long id, CustomerDto customer) {
        return null;
    }

    @Override
    public ApiResponse<Boolean> delete(long id) {
        return null;
    }
}
