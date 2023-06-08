package nguyenhoangthinh.quanlysachCSDLlap3.repository;

import jakarta.persistence.QueryHint;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u where u.username = ?1")
    User findByUsername (String username);
}
