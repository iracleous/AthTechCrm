package gr.athtech.athtechcrm.controller;



import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CrmController {

    private CustomerRepository customerRepository;

    public CrmController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @GetMapping("ping")
    public String ping(){
        return "The API is working";

    }

    @GetMapping("customer")
    public List<Customer> getCustomer(){
        return customerRepository.read();
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerRepository.read(id);
    }

@PutMapping("customer/{id}")
public Customer updateCustomer(@PathVariable int id, @RequestBody  Customer customer){
    return customerRepository.update(id, customer);
}

    @PostMapping("customer")
    public Customer createCustomer(@RequestBody  Customer customer){
        return customerRepository.create(customer);
    }

    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable int id){
        return customerRepository.delete(id);
    }

}
