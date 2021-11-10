package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product  product);
    List<Product> read();
    Product read(long id);
    Product update(long id, Product product);
    boolean delete(long id);
}
