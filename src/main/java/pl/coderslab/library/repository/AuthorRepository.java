package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
