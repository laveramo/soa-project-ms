package fr.insa.app.ms.ListHelpRequestService.model;

import java.text.SimpleDateFormat;
import java.util.*;

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
	
	@Column(name = "Title", nullable = false)
    private String Title;
	
	@Column(name = "Description", nullable = false)
    private String Description;
	
	@Column(name = "Date", nullable = true)
    private Date Date ;
	
	@Column(name = "Status", nullable = false)
    private String Status;
	
	@Column(name = "RequestBy", nullable = false)
    private String RequestBy ;
	
	@Column(name = "Volunteer", nullable = true)
    private String Volunteer ;
    
	public HelpRequest() {
    }
    
	public HelpRequest(int iD, String title, String description, java.util.Date date, String status, String requestBy,
			String volunteer) {
		super();
		ID = iD;
		Title = title;
		Description = description;
		Date = date;
		Status = status;
		RequestBy = requestBy;
		Volunteer = volunteer;
	}

	public HelpRequest(int iD, String title, String description, java.util.Date date, String status, String requestBy) {
		super();
		ID = iD;
		Title = title;
		Description = description;
		Date = date;
		Status = status;
		RequestBy = requestBy;
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
	
	public String getStringDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Format the Date object to a String
        String strDate = formatter.format(Date);
        return strDate;
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
