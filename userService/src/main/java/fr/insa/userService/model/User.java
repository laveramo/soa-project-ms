package fr.insa.userService.model;

public class User {
	private int userID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String PhoneNumber;
	private String Password;

	public User() {
		
	}
	public User(String firstName, String lastName, String email, String phoneNumber) {
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
	}

	public User(String firstName, String lastName, String email, String phoneNumber, String password) {
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
		Password = password;
	}
	
	public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
