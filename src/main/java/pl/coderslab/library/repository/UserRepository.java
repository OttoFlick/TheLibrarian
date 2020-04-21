package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.library.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.login = :login and u.password = :password")
    public User login(@Param("login") String login, @Param("password") String password);
}
