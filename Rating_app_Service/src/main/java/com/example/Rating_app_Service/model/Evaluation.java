package com.example.Rating_app_Service.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Comments") // Vérifiez que le nom correspond à celui de votre table
public class Evaluation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComments ;
	
	@Column(name = "firstName", nullable = false)  //Title ne doit pas etre null  c deja imposer par database 
	@JsonProperty("firstName") // Assure que "Description" dans JSON correspond au champ
    private String firstName;
	
	@Column(name = "lastName", nullable = false)
	@JsonProperty("lastName") // Assure que "Description" dans JSON correspond au champ
	private String lastName;
	
	
	//le profil peut prenre deux valeurs : VOLUNTEER ou HELP_SEEKER
	@Column(name = "profil", nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("profil")
    private ProfilType profil;
	
	public enum ProfilType {
	    VOLUNTEER("volunteer"),
	    HELP_SEEKER("help-seeker");

	    private final String value;

	    ProfilType(String value) {
	        this.value = value;
	    }

	    @Override
	    public String toString() {
	        return value;
	    }
	}

	@Column(name = "comment", nullable = false)
	@JsonProperty("comment")
    private String comment ;
	
	
	
	
	public Evaluation() {}
	
	


	public Evaluation(String firstName, String lastName, ProfilType profil, String comment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.profil = profil;
		this.comment = comment;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public ProfilType getProfil() {
		return profil;
	}




	public void setProfil(ProfilType profil) {
		this.profil = profil;
	}




	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}




	public int getIdComments() {
		return idComments;
	}
	
	

}
