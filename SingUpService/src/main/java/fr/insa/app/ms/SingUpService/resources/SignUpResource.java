package fr.insa.app.ms.SingUpService.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import fr.insa.app.ms.SingUpService.model.User;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/signup")
public class SignUpResource {
	
	
	   @Value("${db.url}")
       private String dbUrl;

       @Value("${db.username}")
       private String dbUsername;

       @Value("${db.password}")
       private String dbPassword;
       
	    @Autowired
	    private UserRepository userRepository;

	    @PostMapping
	    public ResponseEntity<String> createUser( @RequestBody User user) {
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
