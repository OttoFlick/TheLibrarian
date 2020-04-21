package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.library.entity.Book;

import java.util.Collection;


public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.title like %:searchString% or b.category.name like %:searchString% or b.author.firstName like %:searchString% or b.author.lastName like %:searchString%")
    public Collection<Book> findBySearchString(@Param("searchString") String searchString);
}
