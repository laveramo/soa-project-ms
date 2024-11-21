package fri.insa.StudentListService.model;

public class Student {
	private int id;
	private String lastName;
	private String firstName;
	private float average ;
	
	
	


	
	public Student(int id, String lastName, String firstName, float average) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.average = average;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}
}
