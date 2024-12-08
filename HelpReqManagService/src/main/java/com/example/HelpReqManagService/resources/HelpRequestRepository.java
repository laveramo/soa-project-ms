package com.example.HelpReqManagService.resources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.HelpReqManagService.model.HelpRequest;



public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
	
	@Query("SELECT h FROM HelpRequest h WHERE h.Title = :title")
	HelpRequest findByTitle(@Param("title") String title);
;
@Query("SELECT h FROM HelpRequest h WHERE h.Status = :status")
List<HelpRequest> findByStatus(@Param("status") String status);
;

@Query("SELECT h FROM HelpRequest h WHERE h.RequestBy = :seeker")
List<HelpRequest> findByRequestBy(@Param("seeker") String seeker);
;




}
