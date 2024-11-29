package fr.insa.app.ms.SingUpService.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Vérifiez que le nom correspond à celui de votre table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "firstName", nullable = false) // Mapping explicite pour camelCase
    private String firstName;

    @Column(name = "lastName", nullable = false) // Mapping explicite pour camelCase
    private String lastName;

    @Column(name = "phoneNumber", nullable = false) // Mapping explicite pour camelCase
    private String phoneNumber;

    @Column(name = "password", nullable = false)
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
	
	public int getUserID() {
        return ID;
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
