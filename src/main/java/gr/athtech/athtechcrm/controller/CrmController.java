package gr.athtech.athtechcrm.controller;


import gr.athtech.athtechcrm.dto.CustomerDto;
import gr.athtech.athtechcrm.exception.CustomerNotFoundException;
import gr.athtech.athtechcrm.front.ApiResponse;
import gr.athtech.athtechcrm.model.Basket;
import gr.athtech.athtechcrm.model.BasketProduct;
import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.model.Product;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import gr.athtech.athtechcrm.service.BasketService;
import gr.athtech.athtechcrm.service.CustomerService;
import gr.athtech.athtechcrm.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrmController {

    private CustomerService customerService;
    private ProductService productService;

    private BasketService basketService;


    public CrmController(CustomerService customerService, ProductService productService, BasketService basketService) {
        this.customerService = customerService;
        this.productService = productService;
        this.basketService = basketService;
    }


    @GetMapping("ping")
    public String ping() {
        return "The API is working";
    }


    @GetMapping("customer")
    public ApiResponse<List<CustomerDto>> getCustomer() {
        return customerService.read();
    }

    @GetMapping("customer/{id}")
    public ApiResponse<CustomerDto> getCustomer(@PathVariable long id) {
        return customerService.read(id);
    }

    @PutMapping("customer/{id}")
    public ApiResponse<CustomerDto> updateCustomer(@PathVariable long id, @RequestBody CustomerDto customer) {
        return customerService.update(id, customer);
    }

    @PostMapping("customer")
    public ApiResponse<CustomerDto> createCustomer(@RequestBody CustomerDto customer) {
        return customerService.create(customer);
    }

    @DeleteMapping("customer/{id}")
    public ApiResponse<Boolean> deleteCustomer(@PathVariable long id) {
        return customerService.delete(id);
    }


    /////////////////////////


    @GetMapping("product")
    public List<Product> getProduct() {
        return productService.read();
    }


    @PostMapping("product")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }


    @PostMapping("basket/{customerId}")
    public Basket createBasket(@PathVariable int customerId)  {
        try {
            return basketService.create(customerId);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("basket/{basketId}/product/{productId}")
    public BasketProduct createBasketProduct(@PathVariable int basketId, @PathVariable int productId)
            throws CustomerNotFoundException {
        return basketService.addProduct(basketId, productId);
    }

}
