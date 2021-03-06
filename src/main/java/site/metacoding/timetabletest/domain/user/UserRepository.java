package site.metacoding.timetabletest.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE username=:username AND password=:password", nativeQuery = true)
    Optional<User> mLogin(@Param("username") String username, @Param("password") String password);
}
