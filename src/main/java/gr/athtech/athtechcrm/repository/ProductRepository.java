package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
