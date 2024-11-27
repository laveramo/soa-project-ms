package fr.insa.app.ms.LogInService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import fr.insa.app.ms.LogInService.model.Credentials;
import fr.insa.app.ms.LogInService.model.User;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/login")
public class LogInResource {

	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public ResponseEntity<String> getUser(@RequestBody Credentials credentials) {
		try {
			System.out.println("Trying to login");
            User user = userRepository.findByEmail(credentials.getEmail()); // o findByUsername según tu caso

            if (user == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            if (!user.getPassword().equals(credentials.getPassword())) {
                return ResponseEntity.status(401).body("Invalid credentials");
            }

            return ResponseEntity.ok("User logged in successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Could not login");
		}
	}


}
