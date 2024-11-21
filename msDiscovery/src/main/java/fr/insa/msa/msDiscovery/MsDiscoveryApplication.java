package fr.insa.msa.msDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



@SpringBootApplication
@EnableEurekaServer  //nécessaire pour mettre en place le serveur Eureka (votre microservice devient un serveur de découverte
public class MsDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDiscoveryApplication.class, args);
	}

}
