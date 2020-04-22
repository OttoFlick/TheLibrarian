package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.library.entity.Book;
import pl.coderslab.library.entity.Borrowing;

import java.util.Collection;

public interface BorrowRepository extends JpaRepository<Borrowing, Integer> {
    @Query("select b from Borrowing b where b.customer.id = :customerId")
    public Collection<Borrowing> findByCustomerId(@Param("customerId") Integer customerId);
}
