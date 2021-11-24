package gr.athtech.athtechcrm.dto;

import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;

    //mappings
    public Product getProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }

    public ProductDto(Product product){
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        quantity = product.getQuantity();
    }



}
