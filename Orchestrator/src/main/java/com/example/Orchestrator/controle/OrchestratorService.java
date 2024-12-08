package com.example.Orchestrator.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Orchestrator.model.User;

import java.util.List;

@RestController
public class OrchestratorService {
    
	
	@Autowired
    private RestTemplate restTemplate ;
	private static final String USER_MANAGER_SERVICE_BASE_URL = "http://UserManagementService/api/manage";
    
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        // URL du service UserManageService
        String url = USER_MANAGER_SERVICE_BASE_URL + "/create";
        // Envoyer une requête POST avec l'objet User
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, user, String.class);
            return ResponseEntity.ok("Orchestrator: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error in Orchestrator while adding user");
        }
    }
    
    
 // Méthode pour supprimer un utilisateur
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        try {
            String url = USER_MANAGER_SERVICE_BASE_URL + "/delete/" + id;
            restTemplate.delete(url);
            return ResponseEntity.ok("User deleted successfully via Orchestrator!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error in Orchestrator while deleting user");
        }
    }

    // Méthode pour mettre à jour le mot de passe d'un utilisateur
    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable("id") Long id, @RequestParam("newPassword") String newPassword) {
        try {
            String url = USER_MANAGER_SERVICE_BASE_URL + "/updatePassword/" + id + "?newPassword=" + newPassword;
            restTemplate.put(url, null); // PUT peut fonctionner avec null dans le corps si seulement les paramètres d'URL sont utilisés
            return ResponseEntity.ok("Password updated successfully via Orchestrator!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error in Orchestrator while updating password");
        }
    }
    
    
}

