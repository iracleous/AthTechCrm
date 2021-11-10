package gr.athtech.athtechcrm.repository;

import gr.athtech.athtechcrm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByName(String name);
    Optional<Customer> findCustomerByEmail(String email);

    Optional<List<Customer>> findCustomersByName(String name);

}
