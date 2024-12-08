package com.example.Rating_app_Service.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rating_app_Service.model.Evaluation;


@RestController
@RequestMapping("/api/evaluation")
public class EvaluationService {
	
	 @Value("${db.url}")
     private String dbUrl;

     @Value("${db.username}")
     private String dbUsername;

     @Value("${db.password}")
     private String dbPassword;
     
     @Autowired //Injection automatique du repository 
	 private CommentsRepository commentsRepository;
	
    @PostMapping
	public ResponseEntity<String> createComment(@RequestBody Evaluation evaluation) {
        try {
        	commentsRepository.save(evaluation);
            return ResponseEntity.ok("Comment created successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating comment");
        }
    }
}
