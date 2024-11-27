package fr.insa.app.ms.LogInService.resources;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.app.ms.LogInService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}

