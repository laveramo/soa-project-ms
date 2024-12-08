package com.example.UserManagementService.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.UserManagementService.model.User;
@RestController
@RequestMapping("/api/manage")
public class UserManageResource {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            System.out.println("User received: " + user);
            userRepository.save(user);
            return ResponseEntity.ok("User created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating user");
        }
    }

    @GetMapping(value = "users/")
    public List<User> users() {
        return userRepository.findAll();
    }

    // Méthode pour supprimer un utilisateur
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return ResponseEntity.ok("User deleted successfully!");
            } else {
                return ResponseEntity.status(404).body("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error deleting user");
        }
    }

    // Méthode pour mettre à jour le mot de passe d'un utilisateur
    @PutMapping(value = "/updatePassword/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable("id") Long id, @RequestParam("newPassword") String newPassword) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setPassword(newPassword); // Assurez-vous que la méthode setPassword existe dans votre classe User
                userRepository.save(user);
                return ResponseEntity.ok("Password updated successfully!");
            } else {
                return ResponseEntity.status(404).body("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error updating password");
        }
    }
}
