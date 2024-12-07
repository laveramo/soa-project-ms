package com.example.Orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Orchestrator.service.ServiceStarter;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    @Autowired
    private ServiceStarter serviceStarter;

    @PostMapping("/start")
    public String startAllServices() {
        try {
            // Lancer ConfigServer
            serviceStarter.startService("ConfigServer");
            //serviceStarter.waitForHealthCheck("http://localhost:8888/actuator/health");

            // Lancer DiscoveryService
            serviceStarter.startService("DiscoveryService");
            //serviceStarter.waitForHealthCheck("http://localhost:8761/actuator/health");

            // Lancer les autres services
            serviceStarter.startService("LoginService");
            serviceStarter.startService("SignUpService");
            return "Tous les services ont été démarrés avec succès !";
        } catch (Exception e) {
            return "Erreur lors du démarrage des services : " + e.getMessage();
        }
    }
}
