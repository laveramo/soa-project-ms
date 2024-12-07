package com.example.Orchestrator.service;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Service
public class ServiceStarter {

    public void startService(String serviceName) throws IOException {
        // Commande pour démarrer un service (simule ici avec un script ou commande système)
        String command = "mvn spring-boot:run -Dspring-boot.run.arguments=--spring.config.name=" + serviceName.toLowerCase();
        Runtime.getRuntime().exec(command);
        System.out.println(serviceName + " démarré...");
    }

   /* public void waitForHealthCheck(String url) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        while (true) {
            try {
                String response = restTemplate.getForObject(url, String.class);
                if (response != null && response.contains("UP")) {
                    System.out.println("Service disponible à : " + url);
                    break;
                }
            } catch (Exception e) {
                System.out.println("En attente du service à : " + url);
                Thread.sleep(2000);
            }
        }
    }*/
}

