package fr.insa.app.ms.LogInService.model;

public class UserInfo {
	
		private int id;  // o el tipo que uses para el ID
	    private String email;
	    private String name;
	    
		public UserInfo(int id, String email, String name) {
			super();
			this.id = id;
			this.email = email;
			this.name = name;
		}

		public int getId() {
			return id;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
	    
}
