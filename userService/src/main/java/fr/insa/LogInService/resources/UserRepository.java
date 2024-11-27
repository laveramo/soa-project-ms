package fr.insa.LogInService.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.LogInService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}