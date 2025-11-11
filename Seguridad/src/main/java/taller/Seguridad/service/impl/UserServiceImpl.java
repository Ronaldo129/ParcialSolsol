package taller.Seguridad.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import taller.Seguridad.dto.UserRequest;
import taller.Seguridad.dto.UserResponse;
import taller.Seguridad.model.User;
import taller.Seguridad.repository.UserRepository;
import taller.Seguridad.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse save(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        return mapToResponse(repository.save(user));
    }

    @Override
    public Optional<UserResponse> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(this::mapToResponse);
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());
        return response;
    }
}