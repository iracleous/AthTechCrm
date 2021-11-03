package gr.athtech.athtechcrm.controller;



import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import gr.athtech.athtechcrm.service.CustomerService;
import gr.athtech.athtechcrm.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrmController {

    private CustomerService customerService;
    private ProductService productService;

    public CrmController(CustomerService customerService, ProductService productService){
        this.customerService = customerService;
        this.productService = productService;
    }


    @GetMapping("ping")
    public String ping(){
        return "The API is working";
    }

    @GetMapping("customer")
    public List<Customer> getCustomer(){
        return customerService.read();
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.read(id);
    }

@PutMapping("customer/{id}")
public Customer updateCustomer(@PathVariable long id, @RequestBody  Customer customer){
    return customerService.update(id, customer);
}

    @PostMapping("customer")
    public Customer createCustomer(@RequestBody  Customer customer){
        return customerService.create(customer);
    }

    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable long id){
        return customerService.delete(id);
    }

}
