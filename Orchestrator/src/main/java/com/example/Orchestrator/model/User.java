package com.example.Orchestrator.model;
import com.fasterxml.jackson.annotation.JsonProperty;



public class User {


    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    
    private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}
	public User(String FirstName, String LastName, String Email, String PhoneNumber) {
		firstName = FirstName;
		lastName = LastName;
		email = Email;
		phoneNumber = PhoneNumber;
	}

	public User(String FirstName, String LastName, String Email, String PhoneNumber, String Password) {
		firstName = FirstName;
		lastName = LastName;
		email = Email;
		phoneNumber = PhoneNumber;
		password = Password;
	}
	

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public void setLastName(String LastName) {
        lastName = LastName;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        phoneNumber = PhoneNumber;
    }
}
