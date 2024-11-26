package fr.insa.app.ms.SingUpService.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.app.ms.SingUpService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}