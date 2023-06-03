package nguyenhoangthinh.quanlysachCSDLlap3.repository;

import jakarta.persistence.QueryHint;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class IUserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u where ")
}
