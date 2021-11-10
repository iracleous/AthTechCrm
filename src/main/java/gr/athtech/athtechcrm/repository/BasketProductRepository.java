package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
}
