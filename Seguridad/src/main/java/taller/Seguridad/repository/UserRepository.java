package taller.Seguridad.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import taller.Seguridad.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}