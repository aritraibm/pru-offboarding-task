package com.pru.offboarding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.offboarding.task.entity.Training;
import com.pru.offboarding.task.exception.TrainingNotFoundException;
import com.pru.offboarding.task.service.TrainingService;

@CrossOrigin
@RestController
@RequestMapping("/training")
public class TrainingController {

	@Autowired
	private TrainingService service;

	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@PostMapping("/add-training")
	public Training addTraining(@RequestBody Training training) {
		Training trng = service.saveTraining(training);
		return trng;
	}

	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@PutMapping(path ="/{id}")
	public ResponseEntity<?> updateTraining(@RequestBody Training training, @PathVariable("id") String trainingId) {
		Training updatedTraining = null;
		try {
			updatedTraining = service.updateTraining(training, trainingId);
			if(updatedTraining == null) {
				return new ResponseEntity<>("Training not found", HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(updatedTraining, HttpStatus.OK);

			}
		}
		catch(Exception e) {
			return new ResponseEntity<>("Training not found", HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyRole({'ROLE_ASSOCIATE','ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@GetMapping("/get-all-training")
	public List<Training> getAllTraining(){
		List<Training> trainings = service.getAllTraining();
		return trainings;
	}

	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@GetMapping("/{trainingId}")
	public Training getTrainingById(@PathVariable("trainingId") String trainingId) throws TrainingNotFoundException {
		Training trng=null;
		trng=service.getTrainingById(trainingId);	
		return trng;
	}

	@PreAuthorize("hasAnyRole({'ROLE_OFFBOARDING_REVIEWER','ROLE_OFFBOARDING_MANAGER'})")
	@DeleteMapping("/{trainingId}")
	public String deleteTraining(@PathVariable("trainingId") String trainingId) {
		service.deleteTraining(trainingId);
		return "Training "+trainingId+" has been deleted.";
	}

}