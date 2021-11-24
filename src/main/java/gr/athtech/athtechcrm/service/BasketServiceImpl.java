package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.exception.CustomerNotFoundException;
import gr.athtech.athtechcrm.model.*;
import gr.athtech.athtechcrm.repository.BasketProductRepository;
import gr.athtech.athtechcrm.repository.BasketRepository;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import gr.athtech.athtechcrm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService{

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private BasketRepository basketRepository;
    private BasketProductRepository basketProductRepository;

    public BasketServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository,
                             BasketRepository basketRepository, BasketProductRepository basketProductRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.basketRepository = basketRepository;
        this.basketProductRepository = basketProductRepository;
    }

    @Override
    public Basket create(long customerId) throws CustomerNotFoundException {


        Optional<Customer> oCustomer = customerRepository.findById(customerId);
        if (!oCustomer.isPresent()) throw new CustomerNotFoundException("Not found cust = "+customerId);
        Customer customer = oCustomer.get();

        Basket basket = new Basket();

        basket.setCustomer(customer);
        basket.setDateTime(new Date());
        basket.setStatus(Status.OPEN);



        return  basketRepository.save(basket);
    }

    @Override
    public BasketProduct addProduct(long basketId, long productId) throws CustomerNotFoundException {
        Optional<Basket> oBasket = basketRepository.findById(basketId);
        if (!oBasket.isPresent()) throw new CustomerNotFoundException("Not found basket Id = "+basketId);
        Basket basket = oBasket.get();

        Optional<Product> oProduct = productRepository.findById(productId);
        if (!oProduct.isPresent()) throw new CustomerNotFoundException("Not found product Id = "+productId);
        Product product = oProduct.get();

        //to do
        // check if this product already exists in the basket


        // use command to insert or update
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBasket(basket);
        basketProduct.setProduct(product);
        basketProduct.setQuantity(1);


        return basketProductRepository.save(basketProduct);
    }

    @Override
    public boolean deleteProduct(long basketId, long productId) throws CustomerNotFoundException {
        return false;
    }

    @Override
    public List<Basket> read() {
        return null;
    }

    @Override
    public Basket read(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
