package fr.insa.app.ms.HelpRequestService.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.app.ms.HelpRequestService.model.HelpRequest;


public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

}
