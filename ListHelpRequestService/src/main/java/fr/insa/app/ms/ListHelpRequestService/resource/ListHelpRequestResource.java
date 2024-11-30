package fr.insa.app.ms.ListHelpRequestService.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.app.ms.ListHelpRequestService.model.HelpRequest;

@RestController
@RequestMapping("/api/list-help-requests")
public class ListHelpRequestResource {
	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;

	@Autowired
	private HelpRequestRepository hrRepository;

	@GetMapping
	public ResponseEntity<?> getRequests() {
		try {
			List<HelpRequest> requests = hrRepository.findAll();
	        return ResponseEntity.ok(requests);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Could not get the list of requests");
		}
	}
}
