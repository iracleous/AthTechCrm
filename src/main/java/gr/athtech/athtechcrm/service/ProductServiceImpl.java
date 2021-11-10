package gr.athtech.athtechcrm.service;

import gr.athtech.athtechcrm.model.Customer;
import gr.athtech.athtechcrm.model.Product;
import gr.athtech.athtechcrm.repository.CustomerRepository;
import gr.athtech.athtechcrm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository productRepository;

    public ProductServiceImpl( ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product read(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(long id, Product product) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
