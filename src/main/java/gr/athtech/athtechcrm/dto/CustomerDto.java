package gr.athtech.athtechcrm.dto;

import gr.athtech.athtechcrm.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String name;
    private String email;

    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setId(id);
        return customer;
    }

    public CustomerDto(Customer customer){
        name = customer.getName();
        id = customer.getId();
        email = customer.getEmail();
    }
}
