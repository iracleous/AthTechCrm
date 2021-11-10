package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
