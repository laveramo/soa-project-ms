package fr.insa.app.ms.HelpRequestService.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.insa.app.ms.HelpRequestService.model.HelpRequest;


public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
	
	@Query("SELECT h FROM HelpRequest h WHERE h.Title = :title")
	HelpRequest findByTitle(@Param("title") String title);
;




}
