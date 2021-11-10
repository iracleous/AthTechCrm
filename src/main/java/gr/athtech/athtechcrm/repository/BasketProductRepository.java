package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
}
