package taller.Seguridad.service;

import java.util.List;
import java.util.Optional;
import taller.Seguridad.dto.UserRequest;
import taller.Seguridad.dto.UserResponse;

public interface UserService {
    List<UserResponse> findAll();
    UserResponse save(UserRequest request);
    Optional<UserResponse> findByUsername(String username);
}