package Repository.User;

import Entity.User.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsById(long id);

    User getUserById(long id);
}
