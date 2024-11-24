package fri.insa.StudentInfoService.ressources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fri.insa.StudentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.connection}")
	private String typeConnectionDeDB;
	
	@Value("${db.login}")
	private String dblogin;
	
	@Value("${db.pwd}")
	private String dbPWD;
	
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTypeConnectionDeDB() {
		return typeConnectionDeDB;
	}

	public void setTypeConnectionDeDB(String typeConnectionDeDB) {
		this.typeConnectionDeDB = typeConnectionDeDB;
	}

	public String getDblogin() {
		return dblogin;
	}

	public void setDblogin(String dblogin) {
		this.dblogin = dblogin;
	}

	public String getDbPWD() {
		return dbPWD;
	}

	public void setDbPWD(String dbPWD) {
		this.dbPWD = dbPWD;
	}

	@GetMapping("/{idStudent}")
	public StudentInfos getInfoEtudiant(@PathVariable("idStudent") int id) {
		//Simulate the DB with a list
		List<StudentInfos> etudInfos=Arrays.asList(
				new StudentInfos(0,"Godart", "Noemie","12/12/1992"),
				new StudentInfos(1,"Perrin", "Ania","10/02/1993"),
				new StudentInfos(2,"Azi", "Sana","22/05/1992"),
				new StudentInfos(3,"Yala", "Nelia","12/06/1994"));
		System.out.println("Called!");
		System.out.println("Connection à la BDD : "+this.getDbName()+" à l'URI :"+this.getDbPWD());
		
		//Get the student that corresponds to the id 
		return etudInfos.get(id);
	}
	
}
