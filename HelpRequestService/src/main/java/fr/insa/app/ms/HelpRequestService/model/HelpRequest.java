package fr.insa.app.ms.HelpRequestService.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Help_request") 
public class HelpRequest {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID ;
	
	@Column(name = "Title", nullable = false)  //Title ne doit pas etre null  c deja imposer par database 
	@JsonProperty("Title") // Assure que "Description" dans JSON correspond au champ
    private String Title;
	
	@Column(name = "Description", nullable = false)
	@JsonProperty("Description") // Assure que "Description" dans JSON correspond au champ

    private String Description;
	
	@Column(name = "Date", nullable = false)
	@JsonProperty("Date")
    private Date Date  = new Date();
	
	@Column(name = "Status", nullable = true)
	@JsonProperty("Status")
    private String Status = "Waiting";
	
	@Column(name = "RequestBy", nullable = false)
	@JsonProperty("RequestBy")
    private String RequestBy ;
	
	@Column(name = "Volunteer", nullable = true)
	@JsonProperty("Volunteer")
    private String Volunteer ;
	
	
	public HelpRequest() {}
	
	public HelpRequest(String title, String description, java.util.Date date, String status, String requestBy,
			String volunteer) {
		Title = title;
		Description = description;
		Date = (date != null) ? date : new Date();
		Status = (status != null) ? status : "Waiting";
		RequestBy = requestBy;
		Volunteer = volunteer;
	}
	
	public HelpRequest(String title,java.util.Date date, String status, String requestBy,
			String volunteer) {
		Title = title;
		Date = (date != null) ? date : new Date();
		Status = (status != null) ? status : "Waiting";
		RequestBy = requestBy;
		Volunteer = volunteer;
	}
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getRequestBy() {
		return RequestBy;
	}

	public void setRequestBy(String requestBy) {
		RequestBy = requestBy;
	}

	public String getVolunteer() {
		return Volunteer;
	}

	public void setVolunteer(String volunteer) {
		Volunteer = volunteer;
	}

	
}
