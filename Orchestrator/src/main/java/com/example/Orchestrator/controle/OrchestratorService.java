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
	private static final String HELPREQ_MANAGER_SERVICE_BASE_URL = "http://HelpReqManagService//api/helprequest";
    
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
    
   // Appeler la méthode "users" pour récupérer tous les utilisateurs
    @GetMapping("/getAllUsers")
    public ResponseEntity<List> getAllUsers() {
        try {
            String url = USER_MANAGER_SERVICE_BASE_URL + "/users/";
            List users = restTemplate.getForObject(url, List.class); // Récupération des utilisateurs sous forme de liste
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    
    
 // Récupérer toutes les HelpRequest dont le statut est "Waiting"
    @GetMapping("/getWaitingHelpRequests")
    public ResponseEntity<List> getWaitingHelpRequests() {
        try {
            String url = HELPREQ_MANAGER_SERVICE_BASE_URL + "/waiting";
            List helpRequests = restTemplate.getForObject(url, List.class);
            return ResponseEntity.ok(helpRequests);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    // Supprimer une HelpRequest par ID
    @DeleteMapping("/deleteHelpRequest/{id}")
    public ResponseEntity<String> deleteHelpRequest(@PathVariable("id") Long id) {
        try {
            String url = HELPREQ_MANAGER_SERVICE_BASE_URL + "/delete/" + id;
            restTemplate.delete(url);
            return ResponseEntity.ok("HelpRequest deleted successfully via Orchestrator!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error in Orchestrator while deleting HelpRequest");
        }
    }

    // Récupérer toutes les HelpRequest soumises par un RequestBy
    @GetMapping("/getHelpRequestsByRequester/{requestBy}")
    public ResponseEntity<List> getHelpRequestsByRequester(@PathVariable("requestBy") String requestBy) {
        try {
            String url = HELPREQ_MANAGER_SERVICE_BASE_URL + "/by-requester/" + requestBy;
            List helpRequests = restTemplate.getForObject(url, List.class);
            return ResponseEntity.ok(helpRequests);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    
}

