package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.entity.Borrowing;

public interface BorrowRepository extends JpaRepository<Borrowing, Integer> {
}
