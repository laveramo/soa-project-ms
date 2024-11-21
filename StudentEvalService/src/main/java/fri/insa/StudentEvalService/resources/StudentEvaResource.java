package fri.insa.StudentEvalService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fri.insa.StudentEvalService.model.Evaluation;

@RestController
@RequestMapping("/evaluation")
public class StudentEvaResource {
	
	
	@GetMapping("/{idStudent}")
	public Evaluation getStudentEval(@PathVariable("idStudent")  int idEtud) {
		
		//Simulate the DB with a list that contains the marks of 4 stidents whose id are 0,1,2,3
		List<Evaluation> evaList=Arrays.asList(
				new Evaluation(0,13F),
				new Evaluation(1,10.65F),
				new Evaluation(2,18F),
				new Evaluation(3,18F));
		
		//Return the evaluation of the specified idStudent
		return evaList.get(idEtud);
	}
	
}
