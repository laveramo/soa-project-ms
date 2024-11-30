package fr.insa.app.ms.ListHelpRequestService.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.insa.app.ms.ListHelpRequestService.model.HelpRequest;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
	
	@Query("SELECT h FROM HelpRequest h WHERE h.RequestBy = :user")
	List<HelpRequest> findByRequestBy(@Param("user") String user);
;

}