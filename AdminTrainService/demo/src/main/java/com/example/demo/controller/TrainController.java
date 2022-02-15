package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admincontrols")
public class TrainController {

	@Autowired
	TrainRepository trainrepository;
	@Autowired
	MongoOperations mongoOperations;
	
	@GetMapping("/")
	public String welcome()
	{
		return("welcome");
	}
	
	@GetMapping("/Trains")
	public List<Train> getAllTrains() {
		return trainrepository.findAll();
	}
	
	@GetMapping("/Trains/{id}")
	public Optional<Train> getTrains(@PathVariable("id") int id) {
		return trainrepository.findById(id);
	}
	
	@PostMapping("/Trains")
	public ResponseEntity<String> add(@RequestBody Train train) {
		trainrepository.save(train);
		return null;
	}
	
	@PutMapping("/Trains/{id}")
	public ResponseEntity<Train> updateTrain(@PathVariable("id") int id, @RequestBody Train train) {
	  trainrepository.save(train);
	  return null;
	}
	
	@DeleteMapping("/Trains/{id}")
	public void deleteTrain(@PathVariable("id") int id) {
	trainrepository.deleteById(id);   
  }
	
	
	@PostMapping("/regexfrom")
	  public List<Train> regexTrains(@RequestBody String fromm){
			

		  Query query = new Query();
		  query.addCriteria(Criteria.where("from").regex(fromm));
		  List<Train> trai = mongoOperations.find(query, Train.class);
		  return trai;
	  }
	  
	  
	  @PostMapping("/regexto")
	  public List<Train> regexTrain(@RequestBody String tooo){
		

		  Query query = new Query();
		  query.addCriteria(Criteria.where("to").regex(tooo));
		  List<Train> trai = mongoOperations.find(query, Train.class);
		  return trai;
	  }
}