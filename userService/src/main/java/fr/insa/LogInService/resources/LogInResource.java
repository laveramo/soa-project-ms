package fr.insa.LogInService.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.LogInService.model.User;
import fr.insa.LogInService.resources.UserRepository;

@RestController
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

}
