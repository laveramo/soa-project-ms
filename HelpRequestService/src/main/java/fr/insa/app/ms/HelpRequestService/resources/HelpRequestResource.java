package fr.insa.app.ms.HelpRequestService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.app.ms.HelpRequestService.model.HelpRequest;


@RestController
@RequestMapping("/api/helprequest")
public class HelpRequestResource {
	
	 @Value("${db.url}")
     private String dbUrl;

     @Value("${db.username}")
     private String dbUsername;

     @Value("${db.password}")
     private String dbPassword;
     
	    @Autowired
	    private HelpRequestRepository helpRequestRepository;

	    @PostMapping
	    public ResponseEntity<String> createHelpRequest(@RequestBody HelpRequest helpRequest) {
	        try {
	            System.out.println("Received HelpRequest: " + helpRequest);
	            System.out.println("Description: " + helpRequest.getDescription());
	            if (helpRequest.getDescription() == null || helpRequest.getDescription().isEmpty()) {
	                return ResponseEntity.badRequest().body("Description cannot be null or empty.");
	            }
	            helpRequestRepository.save(helpRequest);
	            return ResponseEntity.ok("HelpRequest created successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Error creating HelpRequest");
	        }
	    }


	
}
