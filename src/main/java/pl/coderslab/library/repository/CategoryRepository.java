package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
