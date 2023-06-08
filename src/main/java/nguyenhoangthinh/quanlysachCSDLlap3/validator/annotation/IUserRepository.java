package nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.name =?1")
    User findByUsername (String username);


}
