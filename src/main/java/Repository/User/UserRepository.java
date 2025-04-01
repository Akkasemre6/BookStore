package Repository.User;

import Entity.User.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsById(long id);

    User getUserById(long id);


    List<User> findAll();
}
