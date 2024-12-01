package fr.insa.app.ms.HelpRequestService.resources;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     
	    @Autowired //Injection automatique du repository 
	    private HelpRequestRepository helpRequestRepository;

	    @PostMapping
	    public ResponseEntity<String> createHelpRequest(@RequestBody HelpRequest helpRequest) {
	        try {
	        	
	        	if (helpRequest.getDate() == null) {
	                helpRequest.setDate(new Date());
	            }

	            // Asignar "Waiting" si Status es nulo
	            if (helpRequest.getStatus() == null || helpRequest.getStatus().isEmpty()) {
	                helpRequest.setStatus("Waiting");
	            }
	            
	            if (helpRequest.getDescription() == null || helpRequest.getDescription().isEmpty()) {
	                return ResponseEntity.badRequest().body("Description cannot be null or empty.");
	            }
	            
	            if (helpRequest.getRequestBy() == null || helpRequest.getRequestBy().isEmpty()) {
	                return ResponseEntity.badRequest().body("RequestBy cannot be null or empty.");
	            }
	            
	            helpRequestRepository.save(helpRequest);
	            return ResponseEntity.ok("HelpRequest created successfully!");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Error creating HelpRequest");
	        }
	    }
	    
	    //pour tester : localhost:8086/api/helprequest/update?Status=Waiting&Title=pdla
	    @PutMapping("/update_Status")
	    public ResponseEntity<String> UpdateHelpRequest(@RequestParam String Status, @RequestParam int Id) {
	        try {
	            
	        	Optional<HelpRequest> optionalHelpRequest = helpRequestRepository.findById((long) Id);

	        	if (optionalHelpRequest.isEmpty()) {
	        	    return ResponseEntity.badRequest().body("No HelpRequest found to update");
	        	}
	            
	        	HelpRequest helpRequest = optionalHelpRequest.get();
	        	helpRequest.setStatus(Status);
	        	helpRequestRepository.save(helpRequest);
	        	return ResponseEntity.ok("HelpRequest updated successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Error updating HelpRequest");
	        }
	    }
	    
	    
	  //pour tester : localhost:8086/api/helprequest/assign_volunteer?Volunteer=Donia&Id=8
	    @PutMapping("/assign_volunteer")
	    public ResponseEntity<String> AssignVolunteertoRequest(@RequestParam String Volunteer, @RequestParam int Id) {
	        try {
	        	Optional<HelpRequest> optionalHelpRequest = helpRequestRepository.findById((long) Id);

	        	if (optionalHelpRequest.isEmpty()) {
	                return ResponseEntity.badRequest().body("No HelpRequest found with the given title.");
	            }
	            
	        	HelpRequest helpRequest = optionalHelpRequest.get();
	            helpRequest.setVolunteer(Volunteer);
	            helpRequestRepository.save(helpRequest);
	            return ResponseEntity.ok("Volunteer attributed successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Error attributing Volunteer");
	        }
	    }


	
}
