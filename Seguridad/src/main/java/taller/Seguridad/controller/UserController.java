package taller.Seguridad.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import taller.Seguridad.dto.UserRequest;
import taller.Seguridad.dto.UserResponse;
import taller.Seguridad.service.UserService;
 import java.util.Map;   

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return service.findAll();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return service.save(request);
    }

    @GetMapping("/{username}")
    public Optional<UserResponse> findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }
     @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        boolean success = service.login(username, password);

        return success ? "✅ Login exitoso" : "❌ Usuario o contraseña incorrectos";
    }
}