package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.exception.CustomerNotFoundException;
import gr.athtech.athtechcrm.model.Basket;
import gr.athtech.athtechcrm.model.BasketProduct;
import gr.athtech.athtechcrm.model.Customer;

import java.util.List;

public interface BasketService {
    Basket create( long customerId) throws CustomerNotFoundException;

    BasketProduct addProduct(long basketId, long productId) throws CustomerNotFoundException ;
    boolean deleteProduct(long basketId, long productId) throws CustomerNotFoundException ;

    List<Basket> read();
    Basket read(long id);

    boolean delete(long id);


}
