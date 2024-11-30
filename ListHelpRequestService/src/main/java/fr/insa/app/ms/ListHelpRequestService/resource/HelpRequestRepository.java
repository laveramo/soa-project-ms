package fr.insa.app.ms.ListHelpRequestService.resource;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.app.ms.ListHelpRequestService.model.HelpRequest;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

}