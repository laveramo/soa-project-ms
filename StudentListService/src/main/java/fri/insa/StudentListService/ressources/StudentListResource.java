package fri.insa.StudentListService.ressources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fri.insa.StudentListService.model.Evaluation;
import fri.insa.StudentListService.model.Student;
import fri.insa.StudentListService.model.StudentIDList;
import fri.insa.StudentListService.model.StudentInfos;

@RestController
@RequestMapping("/students")
public class StudentListResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ids/{idSpeciality}")
	public StudentIDList getIDStudents(@PathVariable("idSpeciality") String speciality) {
		
		//Simulate the database using an object StudentIDList, which contains a list of a list of integers
		StudentIDList studentsId=new StudentIDList();
		studentsId.saddStudentToList(0);
		studentsId.saddStudentToList(1);
		studentsId.saddStudentToList(2);
		studentsId.saddStudentToList(3);
		
		return studentsId;
	}
	
	
	@GetMapping("/all/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality") String idSpeciality){
		//Simulate the database using an object StudentIDList, which contains a list of a list of integers
				StudentIDList students=new StudentIDList();
				students.saddStudentToList(0);
				students.saddStudentToList(1);
				students.saddStudentToList(2);
				students.saddStudentToList(3);
				
		//Instanciate RestTemplate for Rest calls
		//RestTemplate restTemplate = new RestTemplate(); j'ai plus besoin grace au Autowired
		int i =0;
		List<Student> listStudents=new ArrayList<Student>();
		
		while(i<students.getStudentList().size()){
			//call the ms to get student's information.
			//the result is deserialized into stuentInfos java object
			StudentInfos etudInfos=restTemplate.getForObject("http://StudentInfoService/student/"+i, StudentInfos.class);
			
			//call the ms to get student's evaluation.
			//the result is deserialized into evaluation java object
			Evaluation eval=restTemplate.getForObject("http://StudentEvalService/evaluation/"+i, Evaluation.class);
			//Instanciate a student with his id , his first name , last name , average and store it in the list
			listStudents.add(new Student(i,etudInfos.getFirstName(),etudInfos.getLastName(),eval.getAverage()));
			i++;

		}
		return listStudents;
		
	}
}
