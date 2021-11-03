package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
