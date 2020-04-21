package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.library.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.lastName = ?1")
    public Customer findByLastName(String lastName);
}
